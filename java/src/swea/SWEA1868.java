package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1868 {
    public static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int N;
    public static char[][] board;
    public static int[][] visited;

    public static void dfs(int x, int y) {
        visited[x][y] = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (board[nx][ny] == '*')
                visited[x][y]++;
        }

        if (visited[x][y] == 0) {
            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                    continue;
                if (visited[nx][ny] == -1) {
                    dfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            board = new char[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    visited[i][j] = -1;
                }
            }
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                char[] charArray = line.toCharArray();
                board[i] = charArray;
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == '.' && visited[i][j] == -1) {
                        dfs(i, j);
                        answer++;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
