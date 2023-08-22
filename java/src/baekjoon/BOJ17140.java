package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 17140 이차원 배열과 연산
public class BOJ17140 {
    private static final int MAX_NUM = 101;
    private static int R, C;
    private static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = C = 3;
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (time++ < 101) {
            if (r - 1 < R && c - 1 < C && A[r - 1][c - 1] == k)
                break;

            if (R >= C) arrangeByRow();
            else arrangeByCol();
        }
        if (time == 102) System.out.println(-1);
        else System.out.println(time - 1);
    }

    private static void arrangeByRow() {
        int[][] tmp = new int[100][100];
        int c = 0;
        for (int i = 0; i < R; i++) {
            int[] dp = new int[MAX_NUM];
            for (int j = 0; j < C; j++) {
                dp[A[i][j]] += 1;
            }

            PriorityQueue<Data> pq = new PriorityQueue<>();
            for (int j = 1; j < MAX_NUM; j++) {
                if (dp[j] > 0) {
                    pq.add(new Data(j, dp[j]));
                }
            }

            int index = 0;
            c = Math.max(c, Math.min(100, pq.size() * 2));
            while (!pq.isEmpty()) {
                Data data = pq.poll();
                tmp[i][index++] = data.number;
                tmp[i][index++] = data.size;
                if (index == 100) break;
            }
        }
        C = c;
        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = tmp[i][j];
            }
        }
    }

    private static void arrangeByCol() {
        int[][] tmp = new int[100][100];
        int r = 0;
        for (int j = 0; j < C; j++) {
            int[] dp = new int[MAX_NUM];
            for (int i = 0; i < R; i++) {
                dp[A[i][j]] += 1;
            }

            PriorityQueue<Data> pq = new PriorityQueue<>();
            for (int i = 1; i < MAX_NUM; i++) {
                if (dp[i] > 0) {
                    pq.add(new Data(i, dp[i]));
                }
            }

            int index = 0;
            r = Math.max(r, Math.min(100, pq.size() * 2));
            while (!pq.isEmpty()) {
                Data data = pq.poll();
                tmp[index++][j] = data.number;
                tmp[index++][j] = data.size;
                if (index == 100) break;
            }
        }
        R = r;
        A = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = tmp[i][j];
            }
        }
    }

    private static class Data implements Comparable<Data> {
        int number;
        int size;

        public Data(int number, int size) {
            this.number = number;
            this.size = size;
        }

        @Override
        public int compareTo(Data o) {
            if (this.size == o.size) {
                return this.number - o.number;
            }
            return this.size - o.size;
        }
    }
}
