package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class P67260 {
    private List<List<Integer>> room;
    private int[] indegree;
    private List<List<Integer>> graph;

    private void bfs(int n) {
        room = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            room.add(new ArrayList<>());
        }
        indegree = new int[n];

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    room.get(cur).add(next);
                    indegree[next] += 1;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public boolean solution(int n, int[][] path, int[][] order) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : path) {
            graph.get(p[0]).add(p[1]);
            graph.get(p[1]).add(p[0]);
        }

        bfs(n);

        for (int[] o : order) {
            room.get(o[0]).add(o[1]);
            indegree[o[1]] += 1;

            // 0 부터 시작하지 못하는 경우 제외
            if (o[1] == 0) return false;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);

        for (int i = 0; i < n; i++) {
            if (q.isEmpty()) {
                return false;
            }

            int cur = q.poll();
            for (int next : room.get(cur)) {
                indegree[next] -= 1;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return true;
    }
}
