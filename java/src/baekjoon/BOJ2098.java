package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2098 외판원 순회
/*
외판원 순회 (TSP)
모든 도시들 간에 이동비용이 주어졌을 때 각 도시들을 한번만 방문하고 다시 처음 지점으로 돌아오는 최소 비용을 구하는 문제

0, 1, 2, 3, 4, 5 도시가 있다고 하자.
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 0 이 최소 비용이라는 것을 알고 있다면
0 -> 2 -> 1 -> 3 상황에서는 뒤의 도시를 가지 않더라도 0 -> 2 -> 1 -> 3 -> 4 -> 5 -> 0이 최소 비용 경로라는 것을 알고 있다.
 */
public class BOJ2098 {
    private static final int INF = 1_000_000_000;
    private static int N;
    private static int[][] graph;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 입력 받기
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        // 0 노드에서 검색 시작
        System.out.println(tsp(0, 1));
    }

    private static int tsp(int start, int visited) {
        // start : 현재 위치, visited : 방문 정보

        // 모든 정점 방문 체크
        if (visited == (1 << N) - 1) {
            if (graph[start][0] != 0) {
                return dp[start][visited] = graph[start][0];
            } else return INF;
        }

        // 이미 갱신된 경로인 경우
        if (dp[start][visited] != -1) {
            return dp[start][visited];
        }

        dp[start][visited] = INF;
        for (int i = 1; i < N; i++) {
            // 이미 방문한 점이라면 제외
            if ((visited & (1 << i)) != 0 || graph[start][i] == 0) {
                continue;
            }

            // 다음 점과의 거리 + 이후의 최적 경로의 합이 작은 것이 최적 경로가 된다.
            dp[start][visited] = Math.min(dp[start][visited],
                    graph[start][i] + tsp(i, visited | (1 << i)));
        }
        return dp[start][visited];
    }
}
