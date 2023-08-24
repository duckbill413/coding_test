package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 1251 하나로 (메모리: 118,860 kb, 시간: 779 ms)
public class SWEA1251 {
    private static int N;
    private static double E;
    private static Island[] islands;
    private static List<Edge> edges;
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            islands = new Island[N];
            st = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st2.nextToken());
                islands[i] = new Island(x, y);
            }

            E = Double.parseDouble(br.readLine());

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            edges = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    edges.add(new Edge(i, j,
                            getWeight(islands[i].x, islands[i].y, islands[j].x, islands[j].y)));
                }
            }

            long answer = Math.round(kruskal());
            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static double kruskal() {
        edges.sort(Comparator.comparingDouble(value -> value.weight));

        double result = 0.0;
        for (Edge edge : edges) {
            if (findParent(edge.start) != findParent(edge.end)) {
                result += edge.weight;
                unionParent(edge.start, edge.end);
            }
        }

        return result;
    }

    private static void unionParent(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        if (x != y) parent[x] = y;
    }

    private static int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static double getWeight(int x, int y, int a, int b) {
        return E * (Math.pow(Math.abs(x - a), 2) + Math.pow(Math.abs(y - b), 2));
    }

    private static class Edge {
        int start, end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static class Island {
        int x, y;
        double e;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
