package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1194 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
                if (board[i][j] == '0') {
                    start = new int[]{i, j, 0};
                    board[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(start));
    }

    private static int bfs(int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[1 << 7][N][M];
        for (int i = 0; i < (1 << 7); i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(visited[i][j], -1);
            }
        }
        q.add(start);
        visited[0][start[0]][start[1]] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (board[cur[0]][cur[1]] == '1') {
                return visited[cur[2]][cur[0]][cur[1]];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int key = cur[2];

                if (!inRange(nx, ny) || board[nx][ny] == '#') {
                    continue;
                }
                if (visited[key][nx][ny] == -1 && (board[nx][ny] == '.' || board[nx][ny] == '1')) {
                    visited[key][nx][ny] = visited[key][cur[0]][cur[1]] + 1;
                    q.add(new int[]{nx, ny, key});
                } else if (visited[key][nx][ny] == -1 && (board[nx][ny] >= 'A' && board[nx][ny] <= 'Z')) {
                    if ((key & (1 << (board[nx][ny] - 'A'))) != 0) {
                        visited[key][nx][ny] = visited[key][cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny, key});
                    }
                } else if (board[nx][ny] >= 'a' && board[nx][ny] <= 'z') {
                    int newKey = key | (1 << (board[nx][ny] - 'a'));
                    if (visited[newKey][nx][ny] == -1) {
                        visited[newKey][nx][ny] = visited[key][cur[0]][cur[1]] + 1;
                        q.add(new int[]{nx, ny, newKey});
                    }
                }
            }
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
