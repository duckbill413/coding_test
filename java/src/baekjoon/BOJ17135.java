package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 17135 캐슬 디펜스
public class BOJ17135 {
    private static int[] dx = {0, -1, 0};
    private static int[] dy = {-1, 0, 1};
    private static int N, M, D;
    private static int[][] A;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        A = new int[N + 1][M];
        int enemy = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1) enemy += 1;
            }
        }

        // combination npt 를 이용해서 궁수가 있을 수 있는 조합 계산
        int[] archers = new int[M];
        for (int i = M - 3; i < M; i++) archers[i] = 2;

        do {
            A[N] = archers;
            int[][] B = new int[N + 1][M];
            for (int i = 0; i < N + 1; i++) {
                B[i] = A[i].clone();
            }

            int result = enemy - solution(B, enemy);
            answer = Math.max(answer, result);
        } while (permutation(archers));
        System.out.println(answer);
    }

    private static int solution(int[][] B, int enemy) {
        int move = N;
        while (enemy > 0 && move > 0) {
            Set<Point> kill = new HashSet<>();
            for (int j = 0; j < M; j++) {
                if (B[N][j] == 2) {
                    Point find = bfs(N, j, B);
                    if (find != null) {
                        kill.add(find);
                    }
                }
            }
            for (Point find : kill) {
                B[find.x][find.y] = 0;
                enemy -= 1;
            }
            moveDown(B);
            move--;
        }

        return enemy;
    }

    private static Point bfs(int x, int y, int[][] B) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new Point(x - 1, y, 1));
        visited[x - 1][y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (B[now.x][now.y] == 1) {
                return now;
            }

            if (now.distance + 1 > D) {
                continue;
            }

            for (int d = 0; d < 3; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, now.distance + 1));
                }
            }
        }
        return null;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static class Point {
        int x, y, distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static void moveDown(int[][] B) {
        for (int i = N - 1; i > 0; i--) {
            B[i] = Arrays.copyOf(B[i - 1], M);
        }
        Arrays.fill(B[0], 0);
    }

    private static boolean permutation(int[] archers) {
        int N = archers.length;
        int i = N - 1;
        while (i > 0 && archers[i - 1] >= archers[i]) i--;

        if (i == 0) return false;

        int j = N - 1;
        while (archers[i - 1] >= archers[j]) j--;

        swap(archers, i - 1, j);

        int k = N - 1;
        while (i < k) swap(archers, i++, k--);
        return true;
    }

    private static void swap(int[] archers, int a, int b) {
        archers[a] ^= archers[b];
        archers[b] ^= archers[a];
        archers[a] ^= archers[b];
    }
}
