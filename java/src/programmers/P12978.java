package programmers;

import java.util.*;

public class P12978 {
    private List<List<int[]>> graph;
    private int[] time;

    private int dijkstra(int K) {
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[]{1, 0});
        time[1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (time[cur[0]] < cur[1])
                continue;

            for (int[] next : graph.get(cur[0])) {
                int cost = cur[1] + next[1];
                if (cost < time[next[0]] && cost <= K) {
                    time[next[0]] = cost;
                    q.add(new int[]{next[0], cost});
                }
            }
        }

        int answer = 0;
        for (int t : time) {
            if (t != Integer.MAX_VALUE) {
                answer += 1;
            }
        }

        return answer;
    }

    public int solution(int N, int[][] road, int K) {
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int cost = r[2];

            graph.get(start).add(new int[]{end, cost});
            graph.get(end).add(new int[]{start, cost});
        }

        time = new int[N + 1];
        Arrays.fill(time, Integer.MAX_VALUE);

        return dijkstra(K);
    }
}
