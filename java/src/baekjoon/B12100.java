package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class B12100 {
    private static int N;
    private static int[][] main_board;
    private static int answer;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    public static int[][] deepCopy(int[][] board) {
        int[][] copyBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            copyBoard[i] = board[i].clone();
        }
        return copyBoard;
    }

    public static void move(int count, int[][] board) {
        if (count == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (answer < board[i][j]) {
                        answer = board[i][j];
                    }
                }
            }
            return;
        }

        // left
        int[][] left_board = deepCopy(board);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (left_board[i][j] == 0) {
                    for (int k = j; k < N - 1; k++) {
                        left_board[i][k] = left_board[i][k + 1];
                    }
                    left_board[i][N - 1] = 0;
                } else if (left_board[i][j] == left_board[i][j + 1]) {
                    left_board[i][j] *= 2;
                    for (int k = j + 1; k < N - 1; k++) {
                        left_board[i][k] = left_board[i][k + 1];
                    }
                    left_board[i][N - 1] = 0;
                }
            }
        }
        move(count + 1, left_board);
        // right
        int[][] right_board = deepCopy(board);
        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (right_board[i][j] == 0) {
                    for (int k = j; k > 0; k--) {
                        right_board[i][k] = right_board[i][k - 1];
                    }
                    right_board[i][0] = 0;
                } else if (right_board[i][j] == right_board[i][j - 1]) {
                    right_board[i][j] *= 2;
                    for (int k = j - 1; k > 0; k--) {
                        right_board[i][k] = right_board[i][k - 1];
                    }
                    right_board[i][0] = 0;
                }
            }
        }
        move(count + 1, right_board);
        // up
        int[][] up_board = deepCopy(board);
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (up_board[i][j] == 0) {
                    for (int k = i; k < N - 1; k++) {
                        up_board[k][j] = up_board[k + 1][j];
                    }
                    up_board[N - 1][j] = 0;
                } else if (up_board[i][j] == up_board[i + 1][j]) {
                    up_board[i][j] *= 2;
                    for (int k = i + 1; k < N - 1; k++) {
                        up_board[k][j] = up_board[k + 1][j];
                    }
                    up_board[N - 1][j] = 0;
                }
            }
        }
        move(count + 1, up_board);
        // down
        int[][] down_board = deepCopy(board);
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i > 0; i--) {
                if (down_board[i][j] == 0) {
                    for (int k = i; k > 0; k--) {
                        down_board[k][j] = down_board[k - 1][j];
                    }
                    down_board[0][j] = 0;
                } else if (down_board[i][j] == down_board[i - 1][j]) {
                    for (int k = i - 1; k > 0; k--) {
                        down_board[k][j] = down_board[k - 1][j];
                    }
                    down_board[0][j] = 0;
                }
            }
        }
        move(count+1, down_board);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        main_board = new int[N][N];
        for (int i = 0; i < N; i++) {
            main_board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        move(0, main_board);
        System.out.println(answer);
    }
}
