package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 3124 최소 스패닝 트리 (크루스칼)
public class SWEA3124 {
    private static int M, N;
    private static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edges.add(new Edge(a, b, c));
            }

            sb.append("#").append(test_case).append(" ").append(kruskal()).append("\n");
        }
        System.out.print(sb);
    }

    private static long kruskal() {
        int[] parent = new int[M + 1];
        for (int i = 0; i < M; i++) {
            parent[i] = i;
        }
        edges.sort(Comparator.comparingInt(value -> value.weight));

        long result = 0;
        for (Edge edge : edges) {
            if (findParent(parent, edge.start) != findParent(parent, edge.end)) {
                unionParent(parent, edge.start, edge.end);
                result += edge.weight;
            }
        }
        return result;
    }

    private static int findParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);

        if (a != b) parent[a] = b;
    }

    private static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}

