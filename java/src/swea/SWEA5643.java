package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 키 순서 (메모리: 1,914 ms, 시간: 2143ms)
public class SWEA5643 {
    private static int N, M;
    private static List<List<Integer>> top;
    private static List<List<Integer>> down;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            top = new ArrayList<>();
            down = new ArrayList<>();
            for (int i = 0; i < N + 1; i++) {
                top.add(new ArrayList<>());
                down.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                top.get(s).add(e);
                down.get(e).add(s);
            }
            int result = 0;
            for (int i = 1; i <= N; i++) {
                int t = bfs(i, top);
                int d = bfs(i, down);

                if (t + d + 1 == N) {
                    result += 1;
                }
            }
            sb.append("#").append(test_case).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int start, List<List<Integer>> graph) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] visited = new boolean[N + 1];

        int result = -1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            result += 1;

            for (Integer next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return result;
    }
}
