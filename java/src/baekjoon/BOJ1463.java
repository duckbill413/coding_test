package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1463 1로 만들기 (메모리: 16364KB, 시간: 136ms)
public class BOJ1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        for (int i = 1; i < N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = N; i >= 1; i--) {
            if (i % 3 == 0) {
                dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
            }
            if (i % 2 == 0) {
                dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
            }
            dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
        }

        System.out.println(dp[1]);
    }
}
