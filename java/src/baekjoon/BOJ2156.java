package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2156 포도주 시식
public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(A[1]);
            System.exit(0);
        }
        dp[1] = A[1];
        dp[2] = A[2] + A[1];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(A[i] + A[i - 1] + dp[i - 3], A[i] + dp[i - 2]));
        }
        System.out.println(dp[N]);
    }
}