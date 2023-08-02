package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.Stream;
// 14503 로봇 청소기
public class BOJ14503 {
    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // N * M size
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 청소기의 위치 및 방향
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        // 방안의 상태
        board = new int[N][];
        for (int i = 0; i < N; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[N][M];

        answer = 0;

        // d의 방향 (동, 서) 재매핑
        if (d == 3)
            d = 1;
        else if (d == 1)
            d = 3;
        // 경로 탐색
        dfs(r, c, d);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, int d) {
        if (board[r][c] == 0 && !visited[r][c]) {
            answer++;
        }
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nx = r + dx[(d + i + 1) % 4]; // 주변에 청소 가능한 곳이 있을 경우 90도 회전 필요
            int ny = c + dy[(d + i + 1) % 4];
            if (inRange(nx, ny) && board[nx][ny] == 0 && !visited[nx][ny]) {
                dfs(nx, ny, (d + i + 1) % 4);
                return;
            }
        }

        // 후진 가능 확인
        int nx = r + dx[(d + 2) % 4];
        int ny = c + dy[(d + 2) % 4];
        if (inRange(nx, ny) && board[nx][ny] == 0) {
            dfs(nx, ny, d); // 청소기의 정면 방향은 수정하지 않는다.
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
