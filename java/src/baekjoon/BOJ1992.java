package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1992 쿼드트리 (메모리: 11716ms, 시간: 84ms)
public class BOJ1992 {
    private static int N;
    private static int[][] board;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }

        solution(0, 0, N);
        System.out.println(sb);
    }

    private static void solution(int x, int y, int size) {
        int first = board[x][y];
        boolean flag = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (first != board[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) sb.append(first);
        else {
            int s = size / 2;
            sb.append("(");
            solution(x, y, s);
            solution(x, y + s, s);
            solution(x + s, y, s);
            solution(x + s, y + s, s);
            sb.append(")");
        }
    }
}
