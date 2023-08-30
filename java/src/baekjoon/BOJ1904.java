package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1000001][2];
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = dp[2][1] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i][0] = dp[i - 1][1] % 15746;
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % 15746;
        }

        System.out.println((dp[N][0] + dp[N][1]) % 15746);
    }
}
