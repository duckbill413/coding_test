package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325 {
    public static List<List<Integer>> graph;
    public static Queue<Integer> q;
    public static int[] result;
    public static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N은 컴퓨터의 개수, M은 신뢰하는 연결의 개수
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            // A가 B를 신뢰한다.
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
        }

        result = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        int compValue = -1;
        for (int i = 1; i <= N; i++) {
            if (result[i] > compValue) {
                compValue = result[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == compValue) {
                sb.append(i).append(' ');
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int i) {
        Arrays.fill(visited, false);
        q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    result[nxt]++;
                    q.add(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
