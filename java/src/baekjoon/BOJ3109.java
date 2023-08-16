package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 3109 빵집 (메모리: 46512kb, 시간: 344ms)
public class BOJ3109 {
    private static final int[] dx = {-1, 0, 1};
    private static final int[] dy = {1, 1, 1};
    private static int R, C;
    private static int[][] path;
    private static boolean find;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        path = new int[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                if (tmp.charAt(j) == '.') {
                    path[i][j] = 0;
                } else {
                    path[i][j] = 2;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            find = false;
            dfs(i, 0);
            if (find) answer += 1;
        }

        System.out.println(answer);
    }

    private static void dfs(int x, int y) {
        path[x][y] = 1;
        if (y == C - 1) {
            find = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (inRange(nx, ny) && path[nx][ny] == 0) {
                dfs(nx, ny);
                if (find) break;
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}

