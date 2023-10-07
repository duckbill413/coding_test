package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5656 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, W, H;
    private static int answer;
    private static int TOTAL_COUNT;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] board = new int[H][W];
            TOTAL_COUNT = 0;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if (board[i][j] != 0) TOTAL_COUNT++;
                }
            }

            answer = TOTAL_COUNT;
            dfs(0, 0, board);
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int depth, int total, int[][] board) {
        if (answer == 0) {
            return;
        }
        if (depth == N) {
            answer = Math.min(answer, TOTAL_COUNT - total);
            return;
        }

        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                if (board[j][i] != 0) {
                    boolean[][] visited = new boolean[H][W];
                    int t = bfs(j, i, board, visited);
                    dfs(depth + 1, total + t, reArrange(board, visited));
                    break;
                }
                if (i == W - 1)
                    dfs(depth + 1, total, board);
            }
        }
    }

    private static int bfs(int x, int y, int[][] board, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count += 1;

            for (int i = 0; i < 4; i++) {
                for (int k = 1; k < board[cur[0]][cur[1]]; k++) {
                    int nx = cur[0] + dx[i] * k;
                    int ny = cur[1] + dy[i] * k;
                    if (inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }

    private static int[][] reArrange(int[][] board, boolean[][] visited) {
        int[][] arrange = new int[H][W];
        for (int i = 0; i < W; i++) {
            int idx = H - 1;
            for (int j = H - 1; j >= 0; j--) {
                if (board[j][i] == 0) break;
                if (!visited[j][i]) {
                    arrange[idx--][i] = board[j][i];
                }
            }
        }
        return arrange;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W;
    }
}
