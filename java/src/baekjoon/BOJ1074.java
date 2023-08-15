package baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1074 Z
// 분할정복, 재귀
public class BOJ1074 {
    private static int N, R, C;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = -1;
        int size = (int) Math.pow(2, N);
        solution(0, 0, 0, size);
        System.out.println(answer);
    }

    private static void solution(int x, int y, int cnt, int size) {
        if (x == R && y == C) {
            answer = cnt;
            return;
        }

        if (x <= R && R < x + size && y <= C && C < y + size) {
            int d = size / 2;
            solution(x, y, cnt, d);
            solution(x, y + d, cnt + d * d, d);
            solution(x + d, y, cnt + 2 * d * d, d);
            solution(x + d, y + d, cnt + 3 * d * d, d);
        }
    }
}
