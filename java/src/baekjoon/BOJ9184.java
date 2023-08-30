package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 9184 신나는 함수 실행
public class BOJ9184 {
    private static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        dp = new int[21][21][21];
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == b && b == c && c == -1) break;


            System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
        }
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if (dp[a][b][c] != 0) return dp[a][b][c];

        if (a < b && b < c) {
            dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        }
        return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
