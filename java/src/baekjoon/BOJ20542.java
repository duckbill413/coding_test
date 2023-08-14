package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20542 받아쓰기 (Levenshtein 편집거리 알고리즘)
public class BOJ20542 {
    private static int N, M;
    private static String A, B;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = br.readLine();
        B = br.readLine();

        dp = new int[N + 1][M + 1];
        levenshtein(); // 편집 거리 알고리즘
        System.out.println(dp[N][M]);
    }

    private static void levenshtein() {
        for (int i = 0; i <= N; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= M; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (isCorrect(A.charAt(i - 1), B.charAt(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1,
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
    }

    private static boolean isCorrect(char a, char b) {
        if (a == b) return true;
        else if (a == 'i' && (b == 'i' || b == 'l' || b == 'j')) return true;
        else if (a == 'v' && (b == 'v' || b == 'w')) return true;
        else return false;
    }
}
