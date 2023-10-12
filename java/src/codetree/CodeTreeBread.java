package codetree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 코드트리 빵
public class CodeTreeBread {
    private static final int[] dx = {-1, 0, 0, 1};
    private static final int[] dy = {0, -1, 1, 0};
    private static int[][] map;
    private static int N, M;
    private static Point[] stores;
    private static List<Point> camps;
    private static boolean[][][] visited;
    private static List<Map<Point, Point>> se;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        camps = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    camps.add(new Point(i, j));
                }
            }
        }
        stores = new Point[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stores[i] = new Point(x - 1, y - 1);
        }
        visited = new boolean[M][N][N];
        se = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            se.add(new HashMap<>());
        }

        System.out.println(bfs());
    }

    private static void bfs() {
        int time = 0; // 시간
    }

    private static Point findCloseCamp(Point s) {
        int distance = 1000;
        Point destination = null;
        int idx = -1;
        for (int i = 0; i < camps.size(); i++) {
            int d = getDistance(s, camps.get(i));
            if (distance > d) {
                distance = d;
                destination = camps.get(i);
                idx = i;
            } else if (distance == d) {
                if (destination.x == camps.get(i).x && destination.y > s.y) {
                    destination = camps.get(i);
                    idx = i;
                } else if (destination.x > camps.get(i).x) {
                    destination = camps.get(i);
                    idx = i;
                }
            }
        }
        camps.remove(idx);

        return destination;
    }

    private static int getDistance(Point s, Point e) {
        return Math.abs(s.x - e.x) + Math.abs(s.y - e.y);
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
