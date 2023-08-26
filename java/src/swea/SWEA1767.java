package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1767 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int[][] A;
    private static int connected;
    private static int answer;
    private static List<Core> cores;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            cores = new ArrayList<>();
            A = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                    if (A[i][j] == 1) cores.add(new Core(i, j));
                    if ((A[i][j] == 1) && (i == 0 || i == N - 1 || j == 0 || j == N - 1)) {
                        cores.get(cores.size() - 1).status = true;
                    }
                }
            }

            connected = 0;
            answer = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int connect, int total) {
        if (cores.size() - depth + connect < connected) return;
        if (depth == cores.size()) {
            if (connect >= connected) {
                if (connect > connected) {
                    connected = connect;
                    answer = total;
                } else if (total < answer) {
                    answer = total;
                }
            }
            return;
        }


        Core now = cores.get(depth);
        if (now.status) { // 이미 벽면에 붙어 있는 경우
            dfs(depth + 1, connect + 1, total);
            return;
        }
        // 벽면에 붙어있지 않은 경우
        for (int d = 0; d < 4; d++) {
            // 전류 연결이 가능한 경우 탐색
            if (canConnect(now.x, now.y, d)) {
                int distance = setLine(now.x, now.y, d);
                dfs(depth + 1, connect + 1, total + distance);
                removeLine(now.x, now.y, d);
            }
        }
        // 현재 코어를 연결하지 않는 경우
        dfs(depth + 1, connect, total);
    }

    // 연결이 가능한지 확인
    private static boolean canConnect(int x, int y, int d) {
        x += dx[d];
        y += dy[d];
        while (inRange(x, y) && A[x][y] == 0) {
            x += dx[d];
            y += dy[d];
        }
        if (inRange(x, y)) return false;
        else return true;
    }

    private static int setLine(int x, int y, int d) {
        int length = 0;
        while (inRange(x + dx[d], y + dy[d])) {
            A[x + dx[d]][y + dy[d]] = 2;
            x += dx[d];
            y += dy[d];
            length += 1;
        }
        return length;
    }

    private static void removeLine(int x, int y, int d) {
        while (inRange(x + dx[d], y + dy[d])) {
            A[x + dx[d]][y + dy[d]] = 0;
            x += dx[d];
            y += dy[d];
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static class Core {
        int x, y;
        boolean status;

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
            this.status = false;
        }
    }
}
