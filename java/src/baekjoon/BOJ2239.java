package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class BOJ2239 {
    private static final int SIZE = 9;
    private static int[][] sudocu;
    private static int[][] house;
    private static List<int[]> zeros;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudocu = new int[SIZE][SIZE];
        zeros = new ArrayList<>();
        house = new int[3][SIZE + 1];
        for (int i = 0; i < SIZE; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < SIZE; j++) {
                sudocu[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (sudocu[i][j] == 0) {
                    zeros.add(new int[]{i, j});
                    continue;
                }

                int num = sudocu[i][j];
                house[0][i] |= (1 << num); // 가로
                house[1][j] |= (1 << num); // 세로
                house[2][i / 3 * 3 + j / 3] |= (1 << num); // 3*3
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == zeros.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    sb.append(sudocu[i][j]);
                }
                sb.append('\n');
            }
            System.out.println(sb);
            exit(0);
        }

        int x = zeros.get(depth)[0];
        int y = zeros.get(depth)[1];

        for (int num = 1; num <= 9; num++) {
            if ((house[0][x] & (1 << num)) == 0 &&
                    (house[1][y] & (1 << num)) == 0 &&
                    (house[2][x / 3 * 3 + y / 3] & (1 << num)) == 0) {
                sudocu[x][y] = num;
                int row = house[0][x];
                int col = house[1][y];
                int square = house[2][x / 3 * 3 + y / 3];
                house[0][x] |= (1 << num);
                house[1][y] |= (1 << num);
                house[2][x / 3 * 3 + y / 3] |= (1 << num);

                dfs(depth + 1);

                sudocu[x][y] = 0;
                house[0][x] = row;
                house[1][y] = col;
                house[2][x / 3 * 3 + y / 3] = square;
            }
        }
    }
}