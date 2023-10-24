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
        while (time++ < K) {
            game();
        }
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.point).append(" ");
        }
        System.out.println(sb);
    }

    private static void game() {
        for (int i = 0; i < M; i++) {
            Player me = players[i];
            // step 1 플레이어 이동
            updateDirection(me);

            int nx = me.x + dx[me.d];
            int ny = me.y + dy[me.d];

            me.x = nx;
            me.y = ny;
            // step 2-1 플레이어가 있는지 확인
            Player other = findPlayerInSamePoint(me, nx, ny);
            // 플레이가 없는 경우
            if (other == null) {
                if (!guns[nx][ny].isEmpty()) {
                    if (me.gun > 0) {
                        guns[nx][ny].add(me.gun);
                    }
                    me.gun = guns[nx][ny].poll();
                }
            } else {
                Player[] p = Player.fight(me, other);
                if (p[1].gun > 0) {
                    guns[nx][ny].add(p[1].gun);
                    p[1].gun = 0;
                }
                updateLoseDirection(p[1]);
                p[1].x = p[1].x + dx[p[1].d];
                p[1].y = p[1].y + dy[p[1].d];
                if (!guns[p[1].x][p[1].y].isEmpty()) {
                    p[1].gun = guns[p[1].x][p[1].y].poll();
                }

                if (!guns[p[0].x][p[0].y].isEmpty()) {
                    if (p[0].gun > 0) {
                        guns[p[0].x][p[0].y].add(p[0].gun);
                    }
                    p[0].gun = guns[p[0].x][p[0].y].poll();
                }
            }
        }
    }

    private static Player findPlayerInSamePoint(Player p, int x, int y) {
        for (int i = 0; i < M; i++) {
            if (players[i] == p) continue;
            if (players[i].isInSamePoint(x, y)) {
                return players[i];
            }
        }
        return null;
    }

    private static class Player {
        int x, y, d, power, gun, point;

        public Player(int x, int y, int d, int power) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.power = power;
            this.gun = 0;
            this.point = 0;
        }

        public boolean isInSamePoint(int x, int y) {
            return this.x == x && this.y == y;
        }

        public static Player[] fight(Player a, Player b) {
            int p1 = a.power + a.gun;
            int p2 = b.power + b.gun;

            if (p1 == p2) {
                p1 = a.power;
                p2 = b.power;
            }

            if (p1 > p2) {
                a.point += (a.power + a.gun) - (b.power + b.gun);
                return new Player[]{a, b};
            } else {
                b.point += (b.power + b.gun) - (a.power + a.gun);
                return new Player[]{b, a};
            }
        }
    }

    private static void updateDirection(Player p) {
        int nx = p.x + dx[p.d];
        int ny = p.y + dy[p.d];

        if (!inRange(nx, ny)) {
            p.d = (p.d + 2) % 4;
        }
    }

    private static void updateLoseDirection(Player p) {
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[(p.d + i) % 4];
            int ny = p.y + dy[(p.d + i) % 4];

            if (!inRange(nx, ny)) {
                continue;
            }

            Player other = findPlayerInSamePoint(p, nx, ny);

            if (other == null) {
                p.d = (p.d + i) % 4;
                break;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
