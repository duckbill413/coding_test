package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17779 게리멘더링 2
public class BOJ17779 {
    private static int N;
    private static int[][] A;
    private static int TOTAL;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                TOTAL += A[i][j];
            }
        }

        answer = Integer.MAX_VALUE;
        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 > N) continue;
                        if (y - d1 < 1 || y + d2 > N) continue;

                        solution(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static void solution(int x, int y, int d1, int d2) {
        int[] sector = new int[5];

        boolean[][] border = new boolean[N + 1][N + 1];

        // 경계선 //
        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }
        // 경계선 \\
        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        // sector 1
        for (int r = 1; r < x + d1; r++) {
            for (int c = 1; c <= y; c++) {
                if (border[r][c]) break;
                sector[0] += A[r][c];
            }
        }
        // sector 2
        for (int r = 1; r <= x + d2; r++) {
            for (int c = N; c > y; c--) {
                if (border[r][c]) break;
                sector[1] += A[r][c];
            }
        }
        // sector 3
        for (int r = x + d1; r <= N; r++) {
            for (int c = 1; c < y - d1 + d2; c++) {
                if (border[r][c]) break;
                sector[2] += A[r][c];
            }
        }
        // sector 4
        for (int r = x + d2 + 1; r <= N; r++) {
            for (int c = N; c >= y - d1 + d2; c--) {
                if (border[r][c]) break;
                sector[3] += A[r][c];
            }
        }
        // sector 5
        sector[4] = TOTAL - Arrays.stream(sector).sum();


        int max = Arrays.stream(sector).max().getAsInt();
        int min = Arrays.stream(sector).min().getAsInt();

        answer = Math.min(answer, max - min);
    }
}
