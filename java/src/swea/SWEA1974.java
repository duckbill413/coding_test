package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1974 스도쿠 검증
public class SWEA1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] table = new int[9][9];

            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    table[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean flag = true;
            for (int i = 0; i < 9; i++) {
                if (!checkRow(i, table)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.printf("#%d 0\n", test_case);
                continue;
            }
            for (int i = 0; i < 9; i++) {
                if (!checkCol(i, table)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.printf("#%d 0\n", test_case);
                continue;
            }
            int x = -3;
            int y = 0;
            for (int i = 0; i < 9; i++) {
                if (i % 3 == 0) {
                    x += 3;
                    y = 0;
                } else {
                    y += 3;
                }
                if (!checkBox(x, y, table)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.printf("#%d 0\n", test_case);
                continue;
            }
            System.out.printf("#%d 1\n", test_case);
        }
    }

    private static boolean checkBox(int x, int y, int[][] table) {
        boolean[] visited = new boolean[9];
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (!visited[table[i][j]-1]){
                    visited[table[i][j]-1] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int j, int[][] table) {
        boolean[] visited = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (!visited[table[i][j] - 1]) {
                visited[table[i][j] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int i, int[][] table) {
        boolean[] visited = new boolean[9];
        for (int j = 0; j < 9; j++) {
            if (!visited[table[i][j] - 1]) {
                visited[table[i][j] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
