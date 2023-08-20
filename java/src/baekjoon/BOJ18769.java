package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ18769 {
    private static int[] parent;
    private static int R, C;
    private static List<Point> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            parent = new int[R * C];
            for (int i = 0; i < R * C; i++) parent[i] = i;
            edges = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C - 1; j++) {
                    int w = Integer.parseInt(st.nextToken());
                    edges.add(new Point(i, j, i, j + 1, w));
                }
            }

            for (int i = 0; i < R - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    int w = Integer.parseInt(st.nextToken());
                    edges.add(new Point(i, j, i + 1, j, w));
                }
            }

            edges.sort(Comparator.comparingInt(value -> value.weight));

            int answer = 0;
            for (Point edge : edges) {
                if (findParent(edge.sx * C + edge.sy) != findParent(edge.ex * C + edge.ey)) {
                    unionParent(edge.sx * C + edge.sy, edge.ex * C + edge.ey);
                    answer += edge.weight;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;
        parent[x] = findParent(parent[x]);
        return parent[x];
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if (a != b) parent[a] = b;
    }

    private static class Point {
        int sx, sy, ex, ey;
        int weight;

        public Point(int sx, int sy, int ex, int ey, int weight) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
            this.weight = weight;
        }
    }
}
