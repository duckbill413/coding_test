package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 14891 톱니바퀴
public class BOJ14891 {
    private static int[][] sawtooth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sawtooth = new int[4][8];

        // 톱니바퀴 입력
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                sawtooth[i][j] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 회전 시킬 톱니바퀴 번호
            int d = Integer.parseInt(st.nextToken()); // 회전 방향 (1: 시계, -1: 반시계)
            rotate(n - 1, d, new boolean[4]);
        }

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int answer = 0;
        if (sawtooth[0][0] == 1)
            answer += 1;
        if (sawtooth[1][0] == 1)
            answer += 2;
        if (sawtooth[2][0] == 1)
            answer += 4;
        if (sawtooth[3][0] == 1)
            answer += 8;
        return answer;
    }

    private static void rotate(int n, int d, boolean[] status) {
        // 오른쪽 톱니 바퀴 회전 (left = 2, right = 6)
        status[n] = true;
        if (n < 3 && sawtooth[n][2] != sawtooth[n + 1][6] && !status[n + 1]) {
            rotate(n + 1, d == 1 ? -1 : 1, status);
        }
        // 왼쪽 톱니 바퀴 회전 (right = 6, left = 2`)
        if (n > 0 && sawtooth[n][6] != sawtooth[n - 1][2] && !status[n - 1]) {
            rotate(n - 1, d == 1 ? -1 : 1, status);
        }
        if (d == 1) { // 시계방향 회전
            int last = sawtooth[n][7];
            for (int j = 7; j > 0; j--) {
                sawtooth[n][j] = sawtooth[n][j - 1];
            }
            sawtooth[n][0] = last;
        } else if (d == -1) {
            int first = sawtooth[n][0];
            for (int j = 0; j < 7; j++) {
                sawtooth[n][j] = sawtooth[n][j + 1];
            }
            sawtooth[n][7] = first;
        }
    }
}
