package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15685 {
    private static final int[][] direction = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    private static int N;
    private static boolean[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new boolean[101][101];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragon(x, y, d, g);
        }

        int answer = findSquare(board);
        System.out.println(answer);
    }

    private static int findSquare(boolean[][] board) {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (board[i][j] && board[i + 1][j] && board[i][j + 1] && board[i + 1][j + 1]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static void drawDragon(int x, int y, int d, int g) {
        List<Integer> result = new ArrayList<>();
        result.add(d);

        for (int i = 0; i < g; i++) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add((result.get(j) + 1) % 4);
            }
        }

        board[x][y] = true;
        for (int dir : result) {
            x += direction[dir][0];
            y += direction[dir][1];
            board[x][y] = true;
        }
    }
}
