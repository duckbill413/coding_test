package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//  1753 최단경로 (메모리: 120164kb, 시간: 872ms)
public class BOJ1753 {
    private static int V, E;
    private static List<List<Node>> graph;
    private static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, w));
        }

        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(distance[i]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > distance[cur.node]) continue;

            for (Node next : graph.get(cur.node)) {
                int cost = cur.weight + next.weight;
                if (cost < distance[next.node]) {
                    distance[next.node] = cost;
                    pq.add(new Node(next.node, cost));
                }
            }
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
