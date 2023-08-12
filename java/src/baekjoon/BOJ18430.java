package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18430 무기 공학
public class BOJ18430 {
    private static int N, M;
    private static int[][] A;
    private static boolean[][] check;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean[N][M];

        solution(0, 0);
        System.out.println(answer);
    }

    private static void solution(int index, int total) {
        if (index == N * M) {
            answer = Math.max(answer, total);
            return;
        }

        int x = index / M;
        int y = index % M;

        if (!check[x][y]) {
            if (x - 1 >= 0 && y - 1 >= 0 && !check[x - 1][y] && !check[x][y - 1]) {
                check[x][y] = check[x - 1][y] = check[x][y - 1] = true;
                int t = A[x - 1][y] + A[x][y - 1] + A[x][y] * 2;
                solution(index + 1, total + t);
                check[x][y] = check[x - 1][y] = check[x][y - 1] = false;
            }
            if (x - 1 >= 0 && y + 1 < M && !check[x - 1][y] && !check[x][y + 1]) {
                check[x][y] = check[x - 1][y] = check[x][y + 1] = true;
                int t = A[x - 1][y] + A[x][y + 1] + A[x][y] * 2;
                solution(index + 1, total + t);
                check[x][y] = check[x - 1][y] = check[x][y + 1] = false;
            }
            if (x + 1 < N && y - 1 >= 0 && !check[x + 1][y] && !check[x][y - 1]) {
                check[x][y] = check[x + 1][y] = check[x][y - 1] = true;
                int t = A[x + 1][y] + A[x][y - 1] + A[x][y] * 2;
                solution(index + 1, total + t);
                check[x][y] = check[x + 1][y] = check[x][y - 1] = false;
            }
            if (x + 1 < N && y + 1 < M && !check[x + 1][y] && !check[x][y + 1]) {
                check[x][y] = check[x + 1][y] = check[x][y + 1] = true;
                int t = A[x + 1][y] + A[x][y + 1] + A[x][y] * 2;
                solution(index + 1, total + t);
                check[x][y] = check[x + 1][y] = check[x][y + 1] = false;
            }
        }

        solution(index+1, total);
    }
}
