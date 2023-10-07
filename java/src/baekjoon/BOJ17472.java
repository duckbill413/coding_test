package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 다리 만들기 2
public class BOJ17472 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static int[][] table;
    private static boolean[][] visited;
    private static int isLandNum;
    private static List<List<int[]>> isLandMap;
    private static int[] parent;
    private static int connectCnt;
    private static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        table = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        isLandNum = 1;
        isLandMap = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (table[i][j] != 0 && !visited[i][j]) {
                    List<int[]> bfs = bfs(i, j);
                    isLandNum += 1;
                    isLandMap.add(bfs);
                }
            }
        }

        parent = new int[isLandNum];
        for (int i = 0; i < isLandNum; i++) {
            parent[i] = i;
        }
        connectCnt = 1;
        result = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (List<int[]> isLands : isLandMap) {
            for (int[] isLand : isLands) {
                int nowNum = table[isLand[0]][isLand[1]];
                for (int i = 0; i < 4; i++) {
                    int nx = isLand[0] + dx[i];
                    int ny = isLand[1] + dy[i];
                    int bridgeLength = 0;

                    while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (table[nx][ny] == nowNum) {
                            break;
                        } else if (table[nx][ny] != 0) {
                            if (bridgeLength > 1) {
                                pq.add(new int[]{bridgeLength, nowNum, table[nx][ny]});
                            }
                            break;
                        } else {
                            bridgeLength += 1;
                            if (nx < isLand[0]) {
                                nx -= 1;
                            } else if (nx > isLand[0]) {
                                nx += 1;
                            } else if (ny < isLand[1]) {
                                ny -= 1;
                            } else if (ny > isLand[1]) {
                                ny += 1;
                            }
                        }
                    }
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (findParent(parent, cur[1]) != findParent(parent, cur[2])) {
                unionParent(parent, cur[1], cur[2]);
                result += cur[0];
                connectCnt += 1;
            }
        }

        if ((connectCnt + 1) == isLandNum) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        List<int[]> isLand = new ArrayList<>();
        isLand.add(new int[]{x, y});
        table[x][y] = isLandNum;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!visited[nx][ny] && table[nx][ny] != 0) {
                        table[nx][ny] = isLandNum;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        isLand.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return isLand;
    }

    private static int findParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = findParent(parent, parent[x]);
        }
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a != b) {
            parent[a] = b;
        }
    }
}
