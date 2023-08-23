package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1197 최소 스패닝 트리 (프림)
public class BOJ1197 {
    private static int V, E;
    private static List<List<Node>> graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        System.out.println(prim(1));
    }

    private static int prim(int start) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));
        for (Node node : graph.get(start)) {
            edges.add(new Edge(start, node.node, node.weight));
        }
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;

        int result = 0;
        while (!edges.isEmpty()) {
            Edge cur = edges.poll();

            if (!visited[cur.end]) {
                visited[cur.end] = true;
                result += cur.weight;

                for (Node next : graph.get(cur.end)) {
                    if (!visited[next.node]) {
                        edges.add(new Edge(cur.end, next.node, next.weight));
                    }
                }
            }
        }
        return result;
    }

    private static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private static class Node {
        int node, weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}
