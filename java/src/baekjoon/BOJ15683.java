package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 15683 감시 (메모리: 38856KB, 시간: 268ms)
public class BOJ15683 {
    private static final int[] dx = {0, -1, 1, 0, 0};
    private static final int[] dy = {0, 0, 0, -1, 1};
    private static TreeMap<Integer, int[][]> cases;
    private static int N, M;
    private static int[][] A;
    private static List<Cctv> cctvs;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        cases = new TreeMap<>();
        cases.put(1, new int[][]{
                {1}, {2}, {3}, {4}
        });
        cases.put(2, new int[][]{
                {1, 2}, {3, 4}
        });
        cases.put(3, new int[][]{
                {1, 4}, {4, 2}, {2, 3}, {3, 1}
        });
        cases.put(4, new int[][]{
                {1, 2, 3}, {1, 2, 4}, {2, 3, 4}, {1, 3, 4}
        });
        cases.put(5, new int[][]{
                {1, 2, 3, 4}
        });

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] > 0 && A[i][j] < 6) {
                    cctvs.add(new Cctv(i, j, A[i][j]));
                }
            }
        }

        answer = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[N][M];
        dfs(0, visited);
        System.out.println(answer);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static void search(int x, int y, int d, boolean[][] visited) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (inRange(nx, ny)) {
            if (A[nx][ny] != 6) {
                visited[nx][ny] = true;
                search(nx, ny, d, visited);
            }
        }
    }

    private static int countNotVisited(boolean[][] visited) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0 && !visited[i][j]) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private static void dfs(int depth, boolean[][] visited) {
        if (depth == cctvs.size()) {
            answer = Math.min(answer, countNotVisited(visited));
            return;
        }

        for (int[] path : cases.get(cctvs.get(depth).type)) {
            boolean[][] newVisited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                if (M >= 0) System.arraycopy(visited[i], 0, newVisited[i], 0, M);
            }

            for (int p : path) {
                search(cctvs.get(depth).x, cctvs.get(depth).y, p, newVisited);
            }
            dfs(depth + 1, newVisited);
        }
    }

    private static class Cctv {
        int x, y, type;

        public Cctv(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
