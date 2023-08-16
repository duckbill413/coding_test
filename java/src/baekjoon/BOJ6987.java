package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6987 월드컵
public class BOJ6987 {
    private static final int TEAM_SIZE = 6;
    private static final int ROUND = 4;
    private static final int MATCH_COUNT = 15;
    private static boolean possible;
    private static int[][] matches;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][][] scores = new int[ROUND][TEAM_SIZE][3];
        for (int k = 0; k < ROUND; k++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 18; i++) {
                scores[k][i / 3][i % 3] = Integer.parseInt(st.nextToken());
            }
        }

        matches = new int[MATCH_COUNT][2]; // 최대 경기 가능한 경우
        int num = 0;
        for (int i = 0; i < TEAM_SIZE; i++) {
            for (int j = i + 1; j < TEAM_SIZE; j++) {
                matches[num][0] = i;
                matches[num][1] = j;
                num++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < ROUND; k++) {
            if (solution(scores[k])) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.println(sb);
    }

    private static boolean solution(int[][] scores) {
        // 한 팀당 5번 경기하는지 검사
        for (int i = 0; i < TEAM_SIZE; i++) {
            if (Arrays.stream(scores[i]).sum() != 5) {
                return false;
            }
        }

        possible = false;
        play(0, scores);
        return possible;
    }

    private static void play(int match, int[][] scores) {
        if (possible) return; // 가능한 경우 종료
        if (match == MATCH_COUNT) { // 모든 게임 수행 성공 시 종료
            possible = true;
            return;
        }

        int my = matches[match][0];
        int enemy = matches[match][1];

        // 승 -> 패
        if (scores[my][0] > 0 && scores[enemy][2] > 0) {
            scores[my][0] -= 1;
            scores[enemy][2] -= 1;
            play(match + 1, scores);
            scores[my][0] += 1;
            scores[enemy][2] += 1;
        }
        // 패 -> 승
        if (scores[my][2] > 0 && scores[enemy][0] > 0) {
            scores[my][2] -= 1;
            scores[enemy][0] -= 1;
            play(match + 1, scores);
            scores[my][2] += 1;
            scores[enemy][0] += 1;
        }
        // 무승부
        if (scores[my][1] > 0 && scores[enemy][1] > 0) {
            scores[my][1] -= 1;
            scores[enemy][1] -= 1;
            play(match + 1, scores);
            scores[my][1] += 1;
            scores[enemy][1] += 1;
        }
    }
}
