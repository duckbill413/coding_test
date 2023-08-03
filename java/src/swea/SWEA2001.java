package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    private static int N, M;
    private static int[][] array;
    private static int answer;

    // 2001. 파리 퇴치
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            array = new int[N + 1][N + 1];
            answer = 0;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken()) + array[i - 1][j] + array[i][j - 1] - array[i - 1][j - 1];
                }
            }

            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    int kill = array[i][j] - array[i][j - M] - array[i - M][j] + array[i - M][j - M];
                    answer = Math.max(answer, kill);
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
