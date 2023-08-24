package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 17471 게리멘더링
public class BOJ17141 {
    private static int N;
    private static boolean[][] graph;
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

        graph = new boolean[N][N];
        // 경로 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int adj = Integer.parseInt(st.nextToken());
            for (int j = 0; j < adj; j++) {
                int tmp = Integer.parseInt(st.nextToken()) - 1;
                graph[i][tmp] = true;
                graph[tmp][i] = true;
            }
        }
        visited = new boolean[N];

        answer = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            dfs(i, 1, people[i]);
        }
        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int start, int depth, int total) {
        if (answer == 0) return; // 차이가 0이라면 종료
        if (depth == N) return;
        if (total > TOTAL - total) return;

        visited[start] = true;
        int diff = Math.abs(total - (TOTAL - total));
        if (diff < answer && bfs()) answer = diff;

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] && !visited[j])
                        dfs(j, depth + 1, total + people[j]);
                }
            }
        }
        visited[start] = false;
    }

    private static boolean bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N];
        int start = 0;
        for (int i = 0; i < N; i++) {
            v[i] = visited[i];
            if (!v[i]) start = i;
        }
        q.add(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < N; i++) {
                if (graph[cur][i] && !v[i]) {
                    v[i] = true;
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (!v[i]) return false;
        }
        return true;
    }
}