package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17143 {
    private static int R, C, M;
    private static Shark[][] sea;
    private static List<Shark> sharks;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sea = new Shark[R + 1][C + 1];
        sharks = new ArrayList<>(); // 상어의 크기로 내림차순

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken()); // 속도
            int d = Integer.parseInt(st.nextToken()); // 1~4 : 위, 아래, 우, 좌
            int z = Integer.parseInt(st.nextToken()); // 크기

            Shark shark = new Shark(r, c, s, d, z);
            sea[r][c] = shark;
            sharks.add(shark);
        }

        answer = 0;
        for (int move = 1; move <= C; move++) {
            moveFisherman(move);
            moveSharks();
        }
        System.out.println(answer);
    }

    private static void moveFisherman(int index) {
        Shark shark = null;
        for (int i = 1; i <= R; i++) {
            if (sea[i][index] != null) {
                shark = sea[i][index];
                sea[i][index] = null;
                break;
            }
        }
        if (shark != null) {
            answer += shark.z;
            sharks.remove(shark);
        }
    }

    private static void moveSharks() {
        sharks.sort(Comparator.comparingInt(o -> o.z));
        for (int i = sharks.size() - 1; i >= 0; i--) {
            Shark shark = sharks.get(i);
            int r = shark.r;
            int c = shark.c;
            if (shark.d == 1 || shark.d == 2) {
                int tmp = shark.r + shark.s;
                if (tmp / R != 0 && tmp / R % 2 != 0) {
                    shark.d = shark.d == 1 ? 2 : 1;
                }

                if (shark.d == 1) {
                    shark.r = tmp % R;
                } else {
                    shark.r = R - tmp % R;
                }
            }

            if (shark.d == 3 || shark.d == 4) {
                int tmp = shark.c + shark.s;
                if (tmp / R != 0 && tmp / R % 2 != 0) {
                    shark.d = shark.d == 3 ? 4 : 3;
                }

                if (shark.d == 3) {
                    shark.c = tmp % C;
                } else {
                    shark.c = C - tmp % C;
                }
            }

            if (sea[shark.r][shark.c] != null) {
                // 현재 상어의 크기가 넣는 곳 보다 큰 경우
                if (sea[shark.r][shark.c].z < shark.z) {
                    sea[shark.r][shark.c] = shark;
                    sea[r][c] = null;
                } else {
                    sharks.remove(shark);
                }
            } else {
                sea[shark.r][shark.c] = shark;
                sea[r][c] = null;
            }
        }
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
