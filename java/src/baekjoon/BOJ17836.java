package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 17836 공주님을 구해라!
public class BOJ17836 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M, T;
    private static int[][] board;
    private static int[][] time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        int gramy = 0;
        int gramx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    gramx = i;
                    gramy = j;
                }
            }
        }

        time = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                time[i][j] = 20000;
            }
        }
        bfs(new Pair(0, 0), new Pair(N - 1, M - 1));
        int answer = time[N - 1][M - 1];

        time = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                time[i][j] = 20000;
            }
        }
        bfs(new Pair(0, 0), new Pair(gramx, gramy));
        answer = Math.min(answer, time[gramx][gramy] + (N - gramx - 1) + (M - gramy - 1));

        if (answer <= T) {
            System.out.println(answer);
        } else {
            System.out.println("Fail");
        }
    }

    private static void bfs(Pair start, Pair target) {
        Queue<Pair> q = new LinkedList<>();
        q.add(start);
        time[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Pair now = q.poll();
            if (now.x == target.x && now.y == target.y) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!inRange(nx, ny)) {
                    continue;
                }

                if (time[nx][ny] == 20000 && board[nx][ny] != 1) {
                    q.add(new Pair(nx, ny));
                    time[nx][ny] = time[now.x][now.y] + 1;
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
