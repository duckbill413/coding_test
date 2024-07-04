package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class S7726 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static char[][] map;
    private static List<int[]> human;
    private static List<int[]> ghost;

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static int bfs(List<int[]> start, boolean isHuman) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];
        for (int[] p : start) {
            q.add(p);
            visited[p[0]][p[1]] = 1;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (map[cur[0]][cur[1]] == 'D') {
                return visited[cur[0]][cur[1]];
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                // 기 방문
                if (!inRange(nx, ny) || visited[nx][ny] != 0) {
                    continue;
                }

                // // 사람인 경우 벽 통과 불가
                if (isHuman && map[nx][ny] == '#') {
                    continue;
                }

                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        human = new ArrayList<>();
        ghost = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = tmp.charAt(j);

                if (map[i][j] == 'G') {
                    ghost.add(new int[]{i, j});
                } else if (map[i][j] == 'N') {
                    human.add(new int[]{i, j});
                }
            }
        }

        int humanTime = bfs(human, true);
        int ghostTime = bfs(ghost, false);

        if (humanTime != -1 && humanTime < ghostTime) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}