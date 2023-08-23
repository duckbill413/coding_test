package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 17471 게리멘더링
public class BOJ17471 {
    private static int N;
    private static List<List<Integer>> graph;
    private static int[] people;
    private static int answer;
    private static boolean[] visited;
    private static int TOTAL;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        people = new int[N];

        // 각 도시의 인구수 입력
        TOTAL = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
            TOTAL += people[i];
        }

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        // 경로 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int adj = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adj; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                graph.get(i).add(tmp - 1); // 어차피 input 으로 양방향이 주어짐
            }
        }

        visited = new boolean[N];
        a = b = 0;
        answer = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int start, int size, int total) {
        visited[start] = true;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                findRoot(i);
            }
        }
        boolean flag = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                flag = false;
                break;
            }
        }
        if (flag) return;
        else answer = Math.min(answer, TOTAL - total);

        for (int i = 0; i < N; i++) {
            if (!visited[N]) {

            }
        }
    }

    private static void findRoot(int start) {
        visited[start] = true;

        for (int next : graph.get(start)) {
            findRoot(next);
        }
    }

    private static int bfs(int start, boolean[][] graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            result += people[cur];

            for (int next = 0; next < N; next++) {
                if (graph[cur][next]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
        return result;
    }
}
