package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1868 파핑파핑 지뢰찾기
public class SWEA1868 {
    public static final int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static final int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static int N;
    public static char[][] board;
    public static boolean[][] visited;

    public static boolean checkZero(int x, int y){
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N){
                continue;
            }
            if (board[nx][ny] == '*')
                return false;
        }
        return true;
    }
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (!visited[nx][ny] && board[nx][ny] == '.' && checkZero(nx, ny)){
                dfs(nx, ny);
            } else {
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            N = Integer.parseInt(br.readLine());

            board = new char[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                char[] charArray = line.toCharArray();
                board[i] = charArray;
            }

            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] == '.' && checkZero(i, j)){
                        dfs(i, j);
                        answer++;
                    }
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <N; j++) {
                    if (!visited[i][j] && board[i][j] == '.'){
                        answer++;
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
