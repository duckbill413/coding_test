package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

// 1249 보급로 (우선순위큐)
public class SWEA1249S2 {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[][] path;
    public static boolean[][] visited;
    public static int[][] time;
    public static int N;
    public static int answer;

    public static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.time));
        pq.add(new Point(0, 0, 0));
        time[0][0] = 0;
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Point current = pq.poll();
            int x = current.x;
            int y = current.y;

            if (x == N - 1 && y == N - 1) {
                if (answer > time[x][y])
                    answer = time[x][y];
                continue;
            }

            if (answer <= time[x][y])
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }
                // 방문하지 않았거나, 현재 + 복구 시간 < 이후 시간 인경우
                if (!visited[nx][ny]){
                    visited[nx][ny] = true;
                    time[nx][ny] = time[x][y] + path[nx][ny];
                    pq.add(new Point(nx, ny, time[nx][ny]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());
            answer = Integer.MAX_VALUE;
            path = new int[N][N];
            visited = new boolean[N][N];
            time = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(time[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                path[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            bfs();
            System.out.printf("#%d %d\n", test_case, answer);
        }

        br.close();
    }

    private static class Point {
        public int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
