package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1961 숫자 배열 회전
public class SWEA1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[][] table = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] rotate90 = rotate(table, N);
            int[][] rotate180 = rotate(rotate90, N);
            int[][] rotate270 = rotate(rotate180, N);

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("#%d\n", test_case));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(rotate90[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(rotate180[i][j]);
                }
                sb.append(" ");
                for (int j = 0; j < N; j++) {
                    sb.append(rotate270[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
    }

    private static int[][] rotate(int[][] table, int size) {
        int[][] rotatedTable = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotatedTable[i][j] = table[size-j-1][i];
            }
        }
        return rotatedTable;
    }
}
