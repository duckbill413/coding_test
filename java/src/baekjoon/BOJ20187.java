package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20187 종이접기
public class BOJ20187 {
    private static int[][] A;
    private static int x, y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        char[] orders = new char[K * 2];
        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < K * 2; i++) {
            orders[i] = tmp[i].charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());

        A = new int[256][256];
        x = 1;
        y = 1;
        A[0][0] = H;
        for (int i = 2 * K - 1; i >= 0; i--) {
            switch (orders[i]) {
                case 'D':
                    foldD();
                    break;
                case 'U':
                    foldU();
                    break;
                case 'R':
                    foldR();
                    break;
                case 'L':
                    foldL();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                sb.append(A[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void foldL() {
        for (int i = 0; i < x; i++) {
            for (int j = y; j < 2 * y; j++) {
                A[i][j] = A[i][2 * y - j - 1] ^ 1;
            }
        }
        y *= 2;
    }

    private static void foldR() {
        for (int i = 0; i < x; i++) {
            for (int j = y; j < 2 * y; j++) {
                A[i][j] = A[i][j - y];
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = A[i][2 * y - j - 1] ^ 1;
            }
        }

        y *= 2;
    }

    private static void foldU() {
        for (int j = 0; j < y; j++) {
            for (int i = x; i < 2 * x; i++) {
                A[i][j] = A[2 * x - i - 1][j] ^ 2;
            }
        }
        x *= 2;
    }

    private static void foldD() {
        for (int i = x; i < 2 * x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = A[i - x][j];
            }
        }

        for (int j = 0; j < y; j++) {
            for (int i = 0; i < x; i++) {
                A[i][j] = A[2 * x - i - 1][j] ^ 2;
            }
        }
        x *= 2;
    }

}
