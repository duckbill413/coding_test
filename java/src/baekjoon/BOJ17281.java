package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 17281 야구
public class BOJ17281 {
    private static int N;
    private static int[][] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] order = new int[8];
        for (int i = 1; i <= 8; i++) {
            order[i - 1] = i;
        }

        int answer = 0;
        do {
            // 타자가 타석에 올라가는 순서
            ArrayDeque<Integer> batter = new ArrayDeque<>();
            for (int i = 0; i < 8; i++) {
                if (i < 3)
                    batter.add(order[i]);
                else {
                    if (i == 3) batter.add(0);
                    batter.add(order[i]);
                }
            }

            // 게임 플레이
            answer = Math.max(answer, solution(batter));
        } while (permutation(order));
        System.out.println(answer);
    }

    private static int solution(ArrayDeque<Integer> batter) {
        int score = 0;
        int[] base = new int[3];
        int out = 0;

        int inning = 0;
        while (true) {
            int cur = batter.poll();
            // 아웃
            if (A[inning][cur] == 0) {
                out += 1;
                if (out == 3) {
                    inning += 1;
                    if (inning == N) break;

                    Arrays.fill(base, 0);
                    out = 0;
                }
            } // 안타
            else if (A[inning][cur] == 1) {
                score += one(base);
            } // 2루타
            else if (A[inning][cur] == 2) {
                score += two(base);
            } // 3루타
            else if (A[inning][cur] == 3) {
                score += three(base);
            } // 홈런
            else if (A[inning][cur] == 4) {
                score += homerun(base);
            }

            batter.offerLast(cur);
        }

        return score;
    }

    private static int one(int[] base) {
        int score = base[2];
        base[2] = 0;
        base[2] = base[1];
        base[1] = base[0];
        base[0] = 1;
        return score;
    }

    private static int two(int[] base) {
        int score = base[1] + base[2];
        base[1] = base[2] = 0;
        base[2] = base[0];
        base[1] = 1;
        return score;
    }

    private static int three(int[] base) {
        int score = base[0] + base[1] + base[2];
        base[0] = base[1] = base[2] = 0;
        base[2] = 1;
        return score;
    }

    private static int homerun(int[] base) {
        int score = Arrays.stream(base).sum();
        Arrays.fill(base, 0);
        return score + 1;
    }

    private static boolean permutation(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (p[i - 1] >= p[j]) j--;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) swap(p, i++, k--);
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        p[a] ^= p[b];
        p[b] ^= p[a];
        p[a] ^= p[b];
    }
}
