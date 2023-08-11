package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 2839 설탕 배달 (메모리: 11532kb, 시간: 72ms)
public class BOJ2839 {
    private static final int MAX_VALUE = 2000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            int a = dp[i - 3] == 0 ? MAX_VALUE : dp[i - 3] + 1;
            int b = dp[i - 5] == 0 ? MAX_VALUE : dp[i - 5] + 1;
            dp[i] = Math.min(a, b);
            if (dp[i] == MAX_VALUE) {
                dp[i] = 0;
            }
        }
        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}
