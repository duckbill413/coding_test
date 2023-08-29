package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1149 RGB거리 (메모리: 18512kb, 시간 228ms)
public class BOJ1149 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = A[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = A[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = A[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Arrays.stream(dp[N-1]).min().getAsInt());
    }
}
