package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17406 배열 돌리기 4 (메모리: 86876kb, 시간: 720ms)
public class BOJ17406 {
    private static int N, M, K;
    private static int[][] A;

    private static Order[] orders;
    private static int[] select;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        orders = new Order[K];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            orders[k] = new Order(r - s - 1, c - s - 1, s);
        }
        select = new int[K];
        for (int i = 0; i < K; i++) {
            select[i] = i;
        }
        int answer = Integer.MAX_VALUE;
        do {
            int[][] tmp = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    tmp[i][j] = A[i][j];
                }
            }
            for (int k = 0; k < K; k++) {
                Order order = orders[select[k]];
                tmp = rotate(order.r, order.c, 0, order.s, tmp, new int[N][M]);
            }
            for (int i = 0; i < N; i++) {
                answer = Math.min(answer, Arrays.stream(tmp[i]).sum());
            }
        } while (permutation(select));
        System.out.println(answer);
    }

    private static int[][] rotate(int x, int y, int depth, int s, int[][] tmp, int[][] B) {
        if (depth == s) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (B[i][j] == 0) {
                        B[i][j] = tmp[i][j];
                    }
                }
            }
            return B;
        }

        int move = (s - depth) * 2;
        for (int i = x; i < x + move; i++) {
            B[i][y] = tmp[i + 1][y];
        }
        for (int j = y + move; j > y; j--) {
            B[x][j] = tmp[x][j - 1];
        }
        for (int i = x + move; i > x; i--) {
            B[i][y + move] = tmp[i - 1][y + move];
        }
        for (int j = y; j < y + move; j++) {
            B[x + move][j] = tmp[x + move][j + 1];
        }
        return rotate(x + 1, y + 1, depth + 1, s, tmp, B);
    }

    private static boolean permutation(int[] arr) {
        int N = arr.length;
        int i = N - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) --i;

        if (i == 0) return false;

        int j = N - 1;
        while (arr[i - 1] >= arr[j]) --j;

        swap(arr, i - 1, j);

        int k = N - 1;
        while (i < k) swap(arr, i++, k--);

        return true;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static class Order {
        int r, c, s;

        public Order(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }
}
