package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 3055 탈출
public class BOJ3055 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int R, C;
    private static char[][] mori;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        mori = new char[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                mori[i][j] = tmp.charAt(j);
            }
        }

        int answer = bfs();
        if (answer == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.status));
        int[][] visited = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(visited[i], -1);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mori[i][j] == '*' || mori[i][j] == 'S') {
                    pq.add(new Node(mori[i][j], i, j));
                    visited[i][j] = 0;
                }
            }
        }

        while (!pq.isEmpty()) {
            PriorityQueue<Node> npq = new PriorityQueue<>(Comparator.comparingInt(o -> o.status));
            int size = pq.size();

            for (int s = 0; s < size; s++) {
                Node cur = pq.poll();

                if (mori[cur.x][cur.y] == 'D') {
                    if (cur.status == 'S') {
                        return visited[cur.x][cur.y];
                    } else {
                        return -1;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (!inRange(nx, ny)) continue;
                    if (mori[nx][ny] == 'X') continue;

                    if (cur.status == '*') {
                        if (mori[nx][ny] == '*' || mori[nx][ny] == 'D') continue;
                        mori[nx][ny] = '*';
                        npq.add(new Node('*', nx, ny));
                    } else if (cur.status == 'S' && mori[nx][ny] != '*' && visited[nx][ny] == -1) {
                        visited[nx][ny] = visited[cur.x][cur.y] + 1;
                        npq.add(new Node('S', nx, ny));
                    }
                }
            }
            pq = npq;
        }
        return -1;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    private static class Node {
        char status;
        int x, y;

        public Node(char status, int x, int y) {
            this.status = status;
            this.x = x;
            this.y = y;
        }
    }
}
