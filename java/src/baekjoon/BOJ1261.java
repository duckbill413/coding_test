package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

// 1261 알고스팟
public class BOJ1261 {
    static int N, M;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer = 10001;

    public static boolean inRange(int x, int y) {
        return x >= 0 && x < M && y >= 0 && y < N;
    }

    public static void bfs() {
        visited[0][0] = 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair now = q.poll();

            if (now.x == M - 1 && now.y == N - 1) {
                answer = Math.min(answer, visited[now.x][now.y]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!inRange(nx, ny))
                    continue;

                if (board[nx][ny] == 0 && visited[now.x][now.y] < visited[nx][ny]) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y];
                } else if (board[nx][ny] == 1 && (visited[now.x][now.y] + 1) < visited[nx][ny]) {
                    q.add(new Pair(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            board[i] = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        visited = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = 100001;
            }
        }
        visited[0][0] = 0;
        bfs();

        System.out.println(answer);
    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
