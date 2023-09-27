package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 9205 맥주 마시면서 걸어가기
public class BOJ9205 {
    private static int N;
    private static Point home;
    private static Point destination;
    private static Point[] stores;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            stores = new Point[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            destination = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            visited = new boolean[N];
            if (bfs()) System.out.println("happy");
            else System.out.println("sad");
        }
    }

    private static boolean bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(home);

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (getDistance(cur.x, cur.y, destination.x, destination.y) <= 1000) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                if (getDistance(cur.x, cur.y, stores[i].x, stores[i].y) <= 1000) {
                    visited[i] = true;
                    q.add(stores[i]);
                }
            }
        }
        return false;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int getDistance(int x, int y, int a, int b) {
        return Math.abs(x - a) + Math.abs(y - b);
    }
}
