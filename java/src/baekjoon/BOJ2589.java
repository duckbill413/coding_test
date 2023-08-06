package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2589 보물섬
public class BOJ2589 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int N, M;
    private static char[][] board;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        answer = 0;
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (board[i][j] == 'L'){
                    answer = Math.max(answer, bfs(new Node(i, j)));
                }
            }
        }
        System.out.println(answer);
    }

    private static int bfs(Node start) {
        int[][] visited = initVisit();
        Queue<Node> q = new LinkedList<>();

        q.add(start);
        visited[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!inRange(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny] == Integer.MAX_VALUE && board[nx][ny] == 'L') {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
        return findLongLength(visited);
    }

    private static int findLongLength(int[][] visited) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'L' && visited[i][j] != Integer.MAX_VALUE) {
                    result = Math.max(result, visited[i][j]);
                }
            }
        }
        return result;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static int[][] initVisit() {
        int[][] visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        return visited;
    }

    private static class Node {
        private int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
