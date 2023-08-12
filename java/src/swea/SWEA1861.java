package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1861 정사각형 방 (메모리: 108,300 kb, 시간: 938 ms)
public class SWEA1861 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int[][] board;
    private static int id;
    private static int answer;
    private static int count;
    private static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            id = Integer.MAX_VALUE;
            answer = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        count = 1;
                        dfs(i, j, board[i][j]);
                    }
                }
            }

            sb.append("#").append(test_case).append(" ")
                    .append(id).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int start) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!inRange(nx, ny) || visited[nx][ny]) {
                continue;
            }

            if (board[nx][ny] == board[x][y] + 1 ||
                    board[nx][ny] == board[x][y] - 1) {
                start = Math.min(start, board[nx][ny]); // 시작점으로는 id가 작은것이 된다.
                count += 1;
                dfs(nx, ny, start);
            }
        }

        if (count > answer || (count == answer && start < id)) {
            answer = count;
            id = start;
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}