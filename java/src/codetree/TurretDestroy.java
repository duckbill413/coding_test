package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class TurretDestroy {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[][] dm = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };
    private static int N, M, K;
    private static Turret[][] map;
    private static Turret[] turrets;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Turret[N][M];
        turrets = new Turret[N * M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int power = Integer.parseInt(st.nextToken());
                Turret turret = new Turret(i, j, power);
                map[i][j] = turret;
                turrets[i * M + j] = turret;
            }
        }
        int time = 0; // 공격 시간
        while (time++ < K) {
            Turret[] t = findTurret();
            if (t[0] == t[1]) break;

            t[0].power += (N + M); // 핸드 적용
            t[0].time = time; // 공격자의 공격 시간 갱신
            t[0].restore = time;
            boolean find = laser(t[0], t[1], time);
            if (!find) {
                cannon(t[0], t[1], time);
            }
            restore(time);
        }
        Turret[] t = findTurret();
        System.out.println(t[1].power);
    }

    private static void restore(int time) {
        for (Turret turret : turrets) {
            if (turret.power > 0 && turret.restore != time) {
                turret.power += 1;
            }
        }
    }

    private static boolean laser(Turret attack, Turret defence, int time) {
        Queue<Turret> q = new ArrayDeque<>();
        Turret[][] visited = new Turret[N][M];
        q.add(attack);
        visited[attack.x][attack.y] = attack;

        // 경로 탐색
        while (!q.isEmpty()) {
            Turret cur = q.poll();

            if (cur == defence) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx == N) nx = 0;
                else if (nx == -1) nx = N - 1;
                if (ny == M) ny = 0;
                else if (ny == -1) ny = M - 1;

                if (visited[nx][ny] == null && map[nx][ny].power > 0) {
                    visited[nx][ny] = cur;
                    q.add(map[nx][ny]);
                }
            }
        }

        // 경로 탐색 실패시
        if (visited[defence.x][defence.y] == null) {
            return false;
        }

        // 경로 역 추적 하며 레이저 공격 하기
        Turret cur = defence;
        cur.power -= attack.power % 2 == 0 ? attack.power / 2 : attack.power / 2 + 1;
        while (cur != attack) {
            cur.power -= attack.power / 2;
            cur.restore = time;
            cur = visited[cur.x][cur.y];
        }

        return true;
    }

    private static void cannon(Turret attack, Turret defence, int time) {
        defence.power -= attack.power;
        defence.restore = time;
        for (int i = 0; i < 8; i++) {
            int nx = defence.x + dm[i][0];
            int ny = defence.y + dm[i][1];

            if (nx == N) nx = 0;
            else if (nx == -1) nx = N - 1;
            if (ny == M) ny = 0;
            else if (ny == -1) ny = M - 1;

            if (map[nx][ny].power > 0 && map[nx][ny] != attack) {
                map[nx][ny].power -= attack.power / 2;
                map[nx][ny].restore = time;
            }
        }
    }

    private static Turret[] findTurret() {
        Arrays.sort(turrets);

        // 첫번째 값을 찾기위한 upper_bound
        int start = 0;
        int end = turrets.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (0 >= turrets[mid].power) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        if (start >= turrets.length - 1) {
            return new Turret[]{turrets[turrets.length - 1], turrets[turrets.length - 1]};
        }

        return new Turret[]{turrets[start], turrets[turrets.length - 1]};
    }

    private static class Turret implements Comparable<Turret> {
        int x, y, time, power, restore;

        public Turret(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.time = 0; // 가장 최근 공격한 시간
            this.power = power;
            this.restore = 0;
        }

        @Override
        public int compareTo(Turret o) {
            if (this.power == o.power &&
                    this.time == o.time &&
                    (this.x + this.y) == (o.x + o.y)) {
                return Integer.compare(o.y, this.y);
            }
            if (this.power == o.power &&
                    this.time == o.time) {
                return Integer.compare((o.x + o.y), (this.x + this.y));
            }
            if (this.power == o.power) {
                return Integer.compare(o.time, this.time);
            }
            return Integer.compare(this.power, o.power);
        }
    }
}
