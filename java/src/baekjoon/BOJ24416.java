package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ24416 {
    private static int A, B;
    private static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        A = B = 0;
        fib1(N);

        dp = new int[N+1];
        fib2(N);
        System.out.println(A + " " + B);
    }

    private static int fib1(int n) {
        if (n == 1 || n == 2) {
            A++;
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    private static void fib2(int n) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            B++;
        }
    }
}
