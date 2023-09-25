package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연구소
public class BOJ14502 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static int[][] board;
    private static List<Point> virus;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        answer = 0;
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int index, int count) {
        int x = index / M;
        int y = index % M;
        if (count == 3) {
            answer = Math.max(answer, bfs());
            return;
        } else if (index == N * M) {
            return;
        }

        dfs(index + 1, count);

        if (board[x][y] == 0) {
            board[x][y] = 1;
            dfs(index + 1, count + 1);
            board[x][y] = 0;
        }
    }

    private static int bfs() {
        ArrayDeque<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        virus.forEach(v -> {
            q.add(new Point(v.x, v.y));
            visited[v.x][v.y] = true;
        });

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!inRange(nx, ny)) continue;

                if (board[nx][ny] != 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 1 && !visited[i][j]) {
                    count += 1;
                }
            }
        }
        return count;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
