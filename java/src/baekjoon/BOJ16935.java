package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16935 배열 돌리기 3 (메모리: 59224kb, 시간: 400ms)
public class BOJ16935 {
    private static int N, M, R;
    private static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int order = Integer.parseInt(st.nextToken());
            switch (order) {
                case 1:
                    board = rotateUpDown();
                    break;
                case 2:
                    board = rotateLeftRight();
                    break;
                case 3:
                    board = rotate90();
                    break;
                case 4:
                    board = rotate180();
                    break;
                case 5:
                    board = rotatePartitionRight();
                    break;
                case 6:
                    board = rotatePartitionLeft();
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] rotateUpDown() {
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = board[N - 1 - i][j];
            }
        }
        return result;
    }

    private static int[][] rotateLeftRight() {
        int[][] result = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = board[i][M - 1 - j];
            }
        }
        return result;
    }

    // 우로 회전
    private static int[][] rotate90() {
        int[][] result = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[j][N - i - 1] = board[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        return result;
    }

    // 좌로 회전
    private static int[][] rotate180() {
        int[][] result = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[M - j - 1][i] = board[i][j];
            }
        }
        int tmp = N;
        N = M;
        M = tmp;
        return result;
    }

    // 부분 배열의 우회전
    private static int[][] rotatePartitionRight() {
        int[][] result = new int[N][M];
        int row = N / 2;
        int col = M / 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < row && j < col) {
                    result[i][j] = board[i + row][j];
                } else if (i >= row && j < col) {
                    result[i][j] = board[i][j + col];
                } else if (i >= row && j >= col) {
                    result[i][j] = board[i - row][j];
                } else {
                    result[i][j] = board[i][j - col];
                }
            }
        }
        return result;
    }

    // 부분 배열의 좌회전
    private static int[][] rotatePartitionLeft() {
        int[][] result = new int[N][M];
        int row = N / 2;
        int col = M / 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < row && j < col) {
                    result[i][j] = board[i][j + col];
                } else if (i < row && j >= col) {
                    result[i][j] = board[i + row][j];
                } else if (i >= row && j >= col) {
                    result[i][j] = board[i][j - col];
                } else {
                    result[i][j] = board[i - row][j];
                }
            }
        }
        return result;
    }
}
