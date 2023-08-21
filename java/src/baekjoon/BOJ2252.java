package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 2252 줄세우기 (메모리: 47296KB, 시간: 456ms)
public class BOJ2252 {
    private static int N, M;
    private static int[] dist;
    private static List<List<Integer>> graph;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dist = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[b]++;
            graph.get(a).add(b);
        }

        topology();

        System.out.println(sb);
    }

    private static void topology() {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (dist[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            sb.append(cur).append(" ");

            for (int next : graph.get(cur)) {
                dist[next] -= 1;
                if (dist[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
