package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 9251 LCS
public class BOJ9251 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int N = A.length();
        int M = B.length();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.max(dp[i - 1][j], dp[i][j - 1]) + dp[i][j]);
            }
        }

        System.out.println(dp[N][M]);
    }
}
