package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 13023 ABCDE (메모리: 17628kb, 시간: 228ms)
public class BOJ13023 {
    private static int N, M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static boolean find;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];
        find = false;
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(i, 1);
            if (find) {
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }
        System.out.println(0);
    }

    private static void dfs(int start, int count) {
        if (count == 5) {
            find = true;
            return;
        }

        for (int next : graph.get(start)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, count + 1);
                visited[next] = false;
            }
        }
    }
}
