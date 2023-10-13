package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FightLand {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int N, M, K;
    private static PriorityQueue<Integer>[][] guns;
    private static Player[] players;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 맵의 크기
        M = Integer.parseInt(st.nextToken()); // 플레이어 수
        K = Integer.parseInt(st.nextToken()); // 게임 횟수

        guns = new PriorityQueue[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                guns[i][j] = new PriorityQueue<>((a, b) -> b - a);
                int power = Integer.parseInt(st.nextToken());
                if (power > 0) {
                    guns[i][j].add(power);
                }
            }
        }
        players = new Player[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x, y, d, p;
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            players[i] = new Player(x - 1, y - 1, d, p);
        }

        // game
        int time = 0;
        while (time < K) {

        }
    }

    private static class Player {
        int x, y, d, power, point;

        public Player(int x, int y, int d, int power) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.power = power;
            this.point = 0;
        }
    }

    private static void updateDirection(Player p) {
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];

        if (!inRange(nx, ny)) {
            p.d = (p.d + 2) % 2;
        }
    }

    private static void updateLoseDirection(Player p) {
        for (int i = 0; i < 4; i++) {

        }
    }

    private static Player playerIsExist(Player me) {
        for (int i = 0; i < M; i++) {
            if (players[i] == me) continue;
            int nx = me.x + dx[(me.d + i) % 4];
            int ny = me.y + dy[(me.d + i) % 4];

            if (inRange(nx, ny)) {
                for (int j = 0; j < M; j++) {
                    if (players[i] == me) continue;

                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Point p) {
            return this.x == p.x && this.y == p.y;
        }
    }
}
