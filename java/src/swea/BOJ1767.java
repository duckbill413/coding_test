package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1767 {
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
            boolean[][] visited = new boolean[N][N];
            dfs(0, 0, 0, visited);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int connect, int total, boolean[][] visited) {
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
            dfs(depth + 1, connect + 1, total, visited);
            return;
        }
        // 벽면에 붙어있지 않은 경우
        for (int d = 0; d < 4; d++) {
            boolean[][] copiedVisit = getCopiedVisit(visited);
            int distance = getDistance(now.x, now.y, d, copiedVisit);

            // 연결 설정 불가여도 그대로 진행
            if (distance == -1) {
                dfs(depth + 1, connect, total, copiedVisit);
            } else {
                dfs(depth + 1, connect + 1, total + distance, copiedVisit);
            }
        }
    }

    private static boolean[][] getCopiedVisit(boolean[][] visited) {
        boolean[][] copiedVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            copiedVisit[i] = Arrays.copyOf(visited[i], N);
        }
        return copiedVisit;
    }

    private static int getDistance(int x, int y, int d, boolean[][] visited) {
        int length = 0;

        x += dx[d];
        y += dy[d];
        while (inRange(x, y) && canMove(x, y, visited)) {
            visited[x][y] = true;
            x += dx[d];
            y += dy[d];
            length += 1;
        }

        if (!inRange(x, y)) return length;
        return -1; // 중간에 다른 물체가 있어서 이동 불가
    }

    private static boolean canMove(int x, int y, boolean[][] visited) {
        return A[x][y] == 0 && !visited[x][y];
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
