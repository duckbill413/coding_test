package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1861 정사각형 방 (메모리: 108,300 kb, 시간: 938 ms)
public class SWEA1861 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int[][] board;
    private static int id;
    private static int answer;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            id = Integer.MAX_VALUE;
            answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited = new boolean[N][N];
                    int result = dfs(i, j, 1);
                    if (answer <= result) {
                        if (answer == result)
                            id = Math.min(id, board[i][j]);
                        else id = board[i][j];
                        answer = result;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ")
                    .append(id).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int x, int y, int count) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny)) {
                continue;
            }
            if (!visited[nx][ny] && board[nx][ny] == board[x][y] + 1) {
                count = Math.max(count, dfs(nx, ny, count + 1));
            }
        }
        return count;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}