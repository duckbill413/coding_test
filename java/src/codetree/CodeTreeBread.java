package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

// 코드트리 빵
public class CodeTreeBread {
    private static final Point EMPTY = new Point(-1, -1);
    private static final int MAX_INT = 3000;
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static int[][] map;
    private static int N, M;
    private static Point[] stores;
    private static Point[] people;
    private static int[][] visited;
    private static int time;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        stores = new Point[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stores[i] = new Point(x - 1, y - 1);
        }
        visited = new int[N][N];
        people = new Point[M];
        Arrays.fill(people, EMPTY);
        time = 0;

        while (true) {
            time++;
            solution();
            if (isEnd()) break;
        }

        System.out.println(time);
    }

    private static void solution() {
        // Step 1. 격자에 있는 사람에 한하여 편의점 방향으로 1 이동
        for (int i = 0; i < M; i++) {
            // 격자 밖이거나 이미 편의점에 도착한 경우 스킵
            if (people[i] == EMPTY || people[i].isSame(stores[i])) {
                continue;
            }

            bfs(stores[i]);
            int minDist = MAX_INT + 1;
            int minX = -MAX_INT, minY = -MAX_INT;
            for (int d = 0; d < 4; d++) {
                int nx = people[i].x + dx[d], ny = people[i].y + dy[d];
                if (inRange(nx, ny) && minDist > visited[nx][ny]) {
                    minDist = visited[nx][ny];
                    minX = nx;
                    minY = ny;
                }
            }
            people[i] = new Point(minX, minY);
        }

        // Step 2. 편의점에 도착한 인원들에 한하여 이동 불가능 표시
        for (int i = 0; i < M; i++) {
            if (people[i].isSame(stores[i])) {
                map[people[i].x][people[i].y] = 2;
            }
        }

        // Step 3. 편의점에서 가장 가까운 베이스 캠프를 고르기
        if (time > M) return;

        bfs(stores[time - 1]);
        int minDist = MAX_INT + 1;
        int minX = -MAX_INT, minY = -MAX_INT;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && minDist > visited[i][j]) {
                    minDist = visited[i][j];
                    minX = i;
                    minY = j;
                }
            }
        }

        // 사람의 베이스 캠프 이동 불가 상태로 변환
        people[time - 1] = new Point(minX, minY);
        map[minX][minY] = 2;
    }

    private static void bfs(Point start) {
        // visited 값을 전부 초기화합니다.
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], MAX_INT);
        }
        // 초기 위치를 넣어줍니다.
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(start.x, start.y));
        visited[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (canMove(nx, ny)) {
                    visited[nx][ny] = visited[cur.x][cur.y] + 1;
                    q.add(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean isEnd() {
        for (int i = 0; i < M; i++) {
            if (!people[i].isSame(stores[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static boolean canMove(int x, int y) {
        return inRange(x, y) &&
                visited[x][y] == MAX_INT &&
                map[x][y] != 2;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isSame(Point p) {
            return this.x == p.x && this.y == p.y;
        }
    }
}