package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 1197 최소 스패닝 트리 (크루스칼)
public class BOJ1197S2 {
    private static int M, N;
    private static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

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

        System.out.println(kruskal());
    }

    private static int kruskal() {
        int[] parent = new int[M + 1];
        for (int i = 0; i < M; i++) {
            parent[i] = i;
        }
        edges.sort(Comparator.comparingInt(value -> value.weight));

        int result = 0;
        for (Edge edge : edges) {
            if (findParent(parent, edge.start) != findParent(parent, edge.end)) {
                result += edge.weight;
                unionParent(parent, edge.start, edge.end);
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

