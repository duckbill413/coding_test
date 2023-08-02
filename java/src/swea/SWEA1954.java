package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1954 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            int x = 0;
            int y = -1;
            int d = 0; // 방향
            int num = 1;

            int[][] answer = new int[N][N];
            for (int i = 0; i < N * N; i++) {
                if (!inRange(x + dx[d], y + dy[d]) || answer[x + dx[d]][y+dy[d]] != 0){
                    d++;
                    d %= 4;
                    i--;
                    continue;
                }
                x += dx[d];
                y += dy[d];
                answer[x][y] = num++;
            }
            sb.append("#").append(test_case).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(answer[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
