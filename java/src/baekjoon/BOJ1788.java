package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1788 {
    private static int N;
    private static final int SIZE = 2_000_001;
    private static final int MOD = 1_000_000_000;
    private static int[] dp;

    public static int fn() {
        if (N > 0) {
            for (int i = 1_000_002; i <= N + 1_000_000; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }
        } else {
            for (int i = 999999; i >= N + 1_000_000; i--) {
                dp[i] = (dp[i + 2] - dp[i + 1]) % MOD;
            }
        }
        return dp[N + 1_000_000];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[SIZE];
        dp[1_000_001] = 1;
        int answer = fn();
        if (answer > 0) {
            System.out.println(1);
        } else if (answer < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
        System.out.println(Math.abs(answer));
    }
}
