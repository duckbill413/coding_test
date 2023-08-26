package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 20058 마법사 상어와 파이어스톰
public class BOJ20058 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, Q;
    private static int[][] A;
    private static int length;
    private static int total;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        total = 0;
        length = (int) Math.pow(2, N);
        A = new int[length][length];
        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < length; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                total += A[i][j];
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            firestorm(L);
        }
        System.out.println(total);

        int ice = 0;
        boolean[][] visited = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (A[i][j] > 0 && !visited[i][j]) {
                    ice = Math.max(ice, bfs(i, j, visited));
                }
            }
        }
        System.out.println(ice);
    }

    private static int bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int result = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            result += 1;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (!inRange(nx, ny)) continue;

                if (!visited[nx][ny] && A[nx][ny] > 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return result;
    }

    private static void firestorm(int l) {
        int[][] B;

        int size = (int) Math.pow(2, l);

        if (l > 0) {
            B = new int[length][length];
            for (int i = 0; i < length; i += size) {
                for (int j = 0; j < length; j += size) {

                    for (int x = 0; x < size; x++) {
                        for (int y = 0; y < size; y++) {
                            B[x + i][y + j] = A[size + i - y - 1][j + x];
                        }
                    }
                }
            }
        } else {
            B = A;
        }

        Queue<int[]> melt = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (B[i][j] == 0) continue;
                int find = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (inRange(nx, ny) && B[nx][ny] != 0) {
                        find += 1;
                    }
                }

                if (find <= 2) {
                    melt.add(new int[]{i, j});
                }
            }
        }

        while (!melt.isEmpty()) {
            int[] p = melt.poll();
            B[p[0]][p[1]] -= 1;
            total -= 1;
        }

        A = B;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < length && y >= 0 && y < length;
    }
}
