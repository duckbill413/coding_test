package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6987 {
    private static boolean result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][][] scores = new int[4][6][3];
        for (int k = 0; k < 4; k++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 18; i++) {
                scores[k][i / 3][i % 3] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            result = false;

            boolean flag = true;
            for (int j = 0; j < 6; j++) {
                if (Arrays.stream(scores[i][j]).sum() != 5) {
                    flag = false;
                    sb.append(0).append(" ");
                    break;
                }
            }
            if (!flag) continue;

            solution(0, scores[i]);
            if (result) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static void solution(int team, int[][] scores) {
        if (result) return;
        if (team == 6) {
            boolean isOk = true;
            for (int i = 0; i < 6; i++) {
                if (scores[i][2] != 0 || scores[i][1] != 0) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) result = true;
            return;
        }
//        경우 조합 백트레킹
        int[] p = new int[6];
        int cnt = 0;
        while (++cnt <= scores[team][1]) p[6 - cnt] = 2;
        cnt = 0;
        while (++cnt <= scores[team][0]) p[6 - scores[team][1] - cnt] = 1;

        do {
            // 자기 자신이 선택될 경우는 제외
            if (p[team] == 1) {
                continue;
            }

            int win = 0;
            int draw = 0;
            for (int i = 0; i < 6; i++) {
                if (p[i] == 0) continue;
                if (p[i] == 1 && scores[i][2] > 0) {
                    win++;
                } else if (p[i] == 2 && scores[i][1] > 0) {
                    draw++;
                }
            }
            if (win == scores[team][0] && draw == scores[team][1]) {
                for (int i = 0; i < 6; i++) {
                    if (p[i] == 0) continue;
                    if (p[i] == 1) scores[i][2] -= 1;
                    else if (p[i] == 2) {
                        scores[i][1] -= 1;
                        scores[team][1] -= 1;
                    }
                }

                if (!result) solution(team + 1, scores);

                for (int i = 0; i < 6; i++) {
                    if (p[i] == 0) continue;
                    if (p[i] == 1) scores[i][2] += 1;
                    else if (p[i] == 2) {
                        scores[i][1] += 1;
                        scores[team][1] += 1;
                    }
                }
            }
        } while (permutation(p));
    }

    private static boolean permutation(int[] p) {
        int N = p.length;
        int i = N - 1;
        while (i > 0 && p[i - 1] >= p[i]) --i;

        if (i == 0) return false; // 다음 순열은 없음 (가장 큰 순열의 형태)

        int j = N - 1;
        while (p[i - 1] >= p[j]) --j;

        swap(p, i - 1, j);

        int k = N - 1;
        while (i < k) swap(p, i++, k--);
        return true;
    }

    private static void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }
}
