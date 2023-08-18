package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1260 DFS와 BFS (메모리: 18408KB, 시간: 212ms)
public class BOJ1260 {
    private static List<List<Integer>> graph;
    private static StringBuilder sb;
    private static Set<Integer> visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 간선 번호가 작은 순으로 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        sb = new StringBuilder();
        visited = new HashSet<>();
        dfs(V);
        sb.append("\n");

        visited = new HashSet<>();
        bfs(V);
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited.add(start);
        sb.append(start).append(" ");

        for (int next : graph.get(start)) {
            if (!visited.contains(next)) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited.add(start);

        while (!q.isEmpty()) {
            int current = q.poll();

            sb.append(current).append(" ");

            for (int next : graph.get(current)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.add(next);
                }
            }
        }
    }
}
