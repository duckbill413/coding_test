package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1873 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int H, W;
    private static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            board = new char[H][W];
            int x, y;
            x = y = 0;
            for (int i = 0; i < H; i++) {
                String tmp = br.readLine();
                for (int j = 0; j < W; j++) {
                    board[i][j] = tmp.charAt(j);
                    if (board[i][j] == '<' || board[i][j] == '>' || board[i][j] == '^' || board[i][j] == 'v') {
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            for (int i = 0; i < N; i++) {
                char order = orders.charAt(i);

                if (order == 'U') {
                    if (inRange(x + dx[0], y + dy[0])) {
                        board[x][y] = '.';
                        x += dx[0];
                        y += dy[0];
                        board[x][y] = '^';
                    } else {
                        board[x][y] = '^';
                    }
                } else if (order == 'D') {
                    if (inRange(x + dx[1], y + dy[1])) {
                        board[x][y] = '.';
                        x += dx[1];
                        y += dy[1];
                        board[x][y] = 'v';
                    } else board[x][y] = 'v';
                } else if (order == 'L') {
                    if (inRange(x + dx[2], y + dy[2])) {
                        board[x][y] = '.';
                        x += dx[2];
                        y += dy[2];
                        board[x][y] = '<';
                    } else board[x][y] = '<';
                } else if (order == 'R') {
                    if (inRange(x + dx[3], y + dy[3])) {
                        board[x][y] = '.';
                        x += dx[3];
                        y += dy[3];
                        board[x][y] = '>';
                    } else board[x][y] = '>';
                } else if (order == 'S') {
                    int d = -1;
                    switch (board[x][y]) {
                        case '^':
                            d = 0;
                            break;
                        case 'v':
                            d = 1;
                            break;
                        case '<':
                            d = 2;
                            break;
                        case '>':
                            d = 3;
                            break;
                    }

                    int nx = x;
                    int ny = y;
                    while (canShoot(nx, ny)) {
                        if (board[nx][ny] == '*') {
                            board[nx][ny] = '.';
                            break;
                        }
                        nx += dx[d];
                        ny += dy[d];
                    }
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W && board[x][y] == '.';
    }

    private static boolean canShoot(int x, int y) {
        return x >= 0 && x < H && y >= 0 && y < W && board[x][y] != '#';
    }
}
