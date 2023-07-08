package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 4193 수영대회 결승전 ( 완전 탐색 + 구현 )
public class SWEA4193 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    public static int[][] board;
    public static boolean[][] visited;
    public static int N;
    public static int answer;
    public static Point start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            board = new int[N][N];
            visited = new boolean[N][N];
            answer = -1;

            for (int i = 0; i < N; i++) {
                board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int sx, sy, ex, ey;
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            start = new Point(sx, sy, 0);

            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            end = new Point(ex, ey, Integer.MAX_VALUE);


            bfs();
            System.out.printf("#%d %d\n", test_case, answer);
        }
    }

    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (end.equals(current)) {
                    answer = current.time;
                    continue;
                }

                if (visited[nx][ny] || board[nx][ny] == 1)
                    continue;

                // 소용돌이 인 경우
                if (board[nx][ny] == 2) {
                    // 소용돌이 통과 가능
                    if (current.time % 3 == 2) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, current.time + 1));
                    } else {
                        q.add(new Point(current.x, current.y, current.time+1));
                    }
                } else {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, current.time + 1));
                }
            }
        }
    }

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public boolean equals(Point point) {
            return point.x == x && point.y == y;
        }
    }
}
