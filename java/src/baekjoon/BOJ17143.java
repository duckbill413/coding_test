package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 17143 낚시왕
public class BOJ17143 {
    private static int[] dx = {0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, 1, -1};
    private static int R, C, M;
    private static Shark[][] sea;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 1~4 : 위, 아래, 우, 좌
            int z = Integer.parseInt(st.nextToken()); // 크기

            Shark shark = new Shark(r, c, s, d, z);
            sea[r][c] = shark;
        }

        answer = 0;
        for (int move = 1; move <= C; move++) {
            moveFisherman(move); // 낚시왕 이동 및 상어 사냥
            moveSharks();
        }
        System.out.println(answer);
    }

    private static void moveFisherman(int index) {
        for (int i = 1; i <= R; i++) {
            if (sea[i][index] != null) {
                answer += sea[i][index].z;
                sea[i][index] = null;
                return;
            }
        }
    }

    private static void moveSharks() {
        Shark[][] moved = new Shark[R + 1][C + 1];
        Queue<Shark> sharks = new ArrayDeque<>();
        // 이동할 상어들을 담는다.
        for (int i = 0; i < R + 1; i++) {
            for (int j = 0; j < C + 1; j++) {
                if (sea[i][j] != null) sharks.add(sea[i][j]);
            }
        }

        // 상어들의 이동
        // 상어의 크기가 더 크면 잡아 먹기
        while (!sharks.isEmpty()) {
            Shark cur = sharks.poll();

            for (int i = 0; i < cur.s; i++) {
                int nx = cur.r + dx[cur.d];
                int ny = cur.c + dy[cur.d];

                if (nx < 1 || nx > R || ny < 1 || ny > C) {
                    if (cur.d == 1) cur.d = 2;
                    else if (cur.d == 2) cur.d = 1;
                    else if (cur.d == 3) cur.d = 4;
                    else if (cur.d == 4) cur.d = 3;

                    nx = cur.r + dx[cur.d];
                    ny = cur.c + dy[cur.d];
                }
                cur.r = nx;
                cur.c = ny;
            }

            if (moved[cur.r][cur.c] == null) {
                moved[cur.r][cur.c] = cur;
            } else {
                if (moved[cur.r][cur.c].z < cur.z) {
                    moved[cur.r][cur.c] = cur;
                }
            }
        }

        sea = moved;
    }

    private static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
