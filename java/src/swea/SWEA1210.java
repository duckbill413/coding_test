package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1210 {
    private static final int T = 10;
    private static boolean[][] visited;
    private static int[][] board;
    private static boolean flag;
    private static final int[] dx = {0, 0, -1};
    private static final int[] dy = {-1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= T; test_case++) {
            int t = Integer.parseInt(br.readLine());
            board = new int[100][100];
            flag = false;

            StringTokenizer st;
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if (board[i][j] == 2) {
                        visited = new boolean[100][100];
                        bfs(i, j, test_case);
                        flag = true;
                        break;
                    }
                }
                if (flag)
                    break;
            }

        }
    }

    private static void bfs(int r, int c, int test_case) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            if (now.x == 0) {
                System.out.println("#" + test_case + " " + now.y);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }
                if (board[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                    break;
                }
            }
        }
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}