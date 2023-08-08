package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16926 배열 돌리기 1
public class BOJ16926 {
    private static int N, M, R;
    private static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int r = 0; r < R; r++) {
            int range = Math.min(N, M) / 2;
            A = rotate(0, range, new int[N][M]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] rotate(int depth, int range, int[][] B) {
        if (depth == range) {
            return B;
        }

        int row_move = N - (depth * 2) - 1;
        int col_move = M - (depth * 2) - 1;

        for (int i = depth + row_move; i > depth; i--) {
            B[i][depth] = A[i - 1][depth];
        }
        for (int j = depth + col_move; j > depth; j--) {
            B[depth + row_move][j] = A[depth + row_move][j - 1];
        }
        for (int i = depth; i < depth + row_move; i++) {
            B[i][depth + col_move] = A[i + 1][depth + col_move];
        }
        for (int j = depth; j < depth + col_move; j++) {
            B[depth][j] = A[depth][j + 1];
        }
        return rotate(depth + 1, range, B);
    }
}
