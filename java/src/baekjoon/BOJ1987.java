package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 1987 알파벳 (메모리: 296316KB, 시간: 1928ms)
public class BOJ1987 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static Set<Character> alphabet;
    private static char[][] board;
    private static int R, C;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        alphabet = new HashSet<>();
        answer = 0;

        alphabet.add(board[0][0]);
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int count) {
        if (answer < count) answer = count;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!alphabet.contains(board[nx][ny])) {
                    alphabet.add(board[nx][ny]);
                    dfs(nx, ny, count + 1);
                    alphabet.remove(board[nx][ny]);
                }
            }
        }
    }
}
