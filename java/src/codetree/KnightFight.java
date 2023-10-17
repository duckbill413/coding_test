package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class KnightFight {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    private static int[][] map;
    private static int L, N, Q;
    private static Robot[] robots;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new int[L][L];
        robots = new Robot[N];

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < L; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            robots[i] = new Robot(r, c, h, w, k);
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            solution(id, direction);
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (robots[i].status) {
                answer += robots[i].damage;
            }
        }
        System.out.println(answer);
    }

    private static void solution(int id, int dir) {
        List<Robot> moveRobot = new ArrayList<>();
        Queue<Robot> q = new ArrayDeque<>();
        q.add(robots[id]);

        boolean flag = true;
        while (!q.isEmpty()) {
            Robot cur = q.poll();
            if (moveRobot.contains(cur)) continue;
            if (!cur.status) continue;

            int nx = cur.x + dx[dir];
            int ny = cur.y + dy[dir];

            if (!cur.canMove(nx, ny, dir)) {
                flag = false;
                break;
            }

            moveRobot.add(cur);

            List<Robot> samePlaceRobot = cur.findSamePlaceRobot(nx, ny);
            q.addAll(samePlaceRobot);
        }
        if (flag) {
            move(moveRobot, dir);
            for (int i = 1; i < moveRobot.size(); i++) {
                int damage = moveRobot.get(i).calcDamage();
                moveRobot.get(i).damage(damage);
            }
        }
    }

    private static void move(List<Robot> moveRobots, int dir) {
        for (int i = 0; i < moveRobots.size(); i++) {
            int nx = moveRobots.get(i).x + dx[dir];
            int ny = moveRobots.get(i).y + dy[dir];

            moveRobots.get(i).x = nx;
            moveRobots.get(i).y = ny;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < L && y >= 0 && y < L;
    }

    private static class Robot {
        int x, y, h, w, k;
        int damage;
        boolean status;

        public Robot(int x, int y, int h, int w, int k) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.w = w;
            this.k = k;
            this.damage = 0;
            this.status = true;
        }

        private List<Robot> findSamePlaceRobot(int x, int y) {
            List<Robot> dup = new ArrayList<>();
            for (int k = 0; k < N; k++) {
                if (robots[k] == this) continue;
                if (!robots[k].status) continue;
                for (int i = x; i < x + h; i++) {
                    for (int j = y; j < y + w; j++) {
                        if ((robots[k].x <= i && i < robots[k].x + robots[k].h) &&
                                (robots[k].y <= j && j < robots[k].y + robots[k].w)) {
                            dup.add(robots[k]);
                        }
                    }
                }
            }
            return dup;
        }

        private int calcDamage() {
            int count = 0;
            for (int i = x; i < x + h; i++) {
                for (int j = y; j < y + w; j++) {
                    if (map[i][j] == 1) {
                        count += 1;
                    }
                }
            }
            return count;
        }

        private void damage(int d) {
            this.damage += d;
            if (this.damage >= k) {
                this.status = false;
            }
        }

        private boolean canMove(int x, int y, int d) {
            if (d % 2 == 0) {
                for (int i = 0; i < w; i++) {
                    if (!inRange(x, y + i) || map[x][y + i] == 2) return false;
                    if (!inRange(x + h - 1, y + i) || map[x + h - 1][y + i] == 2) return false;
                }
            } else {
                for (int i = 0; i < h; i++) {
                    if (!inRange(x + i, y) || map[x + i][y] == 2) return false;
                    if (!inRange(x + i, y + w - 1) || map[x + i][y + w - 1] == 2) return false;
                }
            }
            return true;
        }
    }
}