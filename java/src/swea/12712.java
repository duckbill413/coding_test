package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 12712 파리퇴지3
public class SWEA12712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] table = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int case1 = getFly1(i, j, table, N, M);
                    answer = Math.max(answer, case1);
                    int case2 = getFly2(i, j, table, N, M);
                    answer = Math.max(answer, case2);
                }
            }
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private static int getFly2(int i, int j, int[][] table, int n, int m) {
        int result = 0;

        for (int k = -m + 1; k < m; k++) {
            int x = i + k;
            int y = j + k;

            if (x < 0 || x >= n)
                continue;
            if (y < 0 || y >= n)
                continue;

            result += table[x][y];
        }

        for (int k = -m + 1; k < m; k++) {
            int x = i - k;
            int y = j + k;

            if (x < 0 || x >= n)
                continue;
            if (y < 0 || y >= n)
                continue;

            result += table[x][y];
        }
        return result - table[i][j];
    }

    private static int getFly1(int i, int j, int[][] table, int n, int m) {
        int result = 0;

        for (int k = i - m + 1; k < i + m; k++) {
            if (k < 0 || k >= n)
                continue;
            result += table[k][j];
        }

        for (int k = j - m + 1; k < j + m; k++) {
            if (k < 0 || k >= n)
                continue;
            result += table[i][k];
        }

        return result - table[i][j];
    }
}
