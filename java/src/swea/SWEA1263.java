package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1263 사람 네트워크 2
public class SWEA1263 {
    private static int INF = 987654321;
    private static int N;
    private static int[][] edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            edges = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(edges[i], INF);
                edges[i][i] = 0;
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) edges[i][j] = 1;
                }
            }

            for (int k = 0; k < N; k++) {
                for (int s = 0; s < N; s++) {
                    for (int e = 0; e < N; e++) {
                        edges[s][e] = Math.min(edges[s][e], edges[s][k] + edges[k][e]);
                    }
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                answer = Math.min(answer, Arrays.stream(edges[i]).sum());
            }
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
