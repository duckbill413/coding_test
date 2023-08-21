package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ9370 {
    private static int N, M, T;
    private static int S, G, H;
    private static List<List<Node>> graph;
    private static int[] dist;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TEST_CASE = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < TEST_CASE; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
            dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE / 2 * 2);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                if ((a == G && b == H) || (a == H && b == G)) {
                    graph.get(a).add(new Node(b, d * 2 - 1));
                    graph.get(b).add(new Node(a, d * 2 - 1));
                } else {
                    graph.get(a).add(new Node(b, d * 2));
                    graph.get(b).add(new Node(a, d * 2));
                }
            }

            dijkstra(S);

            int[] destination = new int[T];
            for (int i = 0; i < T; i++) destination[i] = Integer.parseInt(br.readLine());

            Arrays.sort(destination);


            for (int i = 0; i < T; i++) {
                if (dist[destination[i]] % 2 != 0) {
                    sb.append(destination[i]).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.weight));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > dist[cur.index])
                continue;

            for (Node next : graph.get(cur.index)) {
                int cost = cur.weight + next.weight;
                if (cost < dist[next.index]) {
                    dist[next.index] = cost;
                    pq.add(new Node(next.index, cost));
                }
            }
        }
    }

    private static class Node {
        int weight, index;

        public Node(int index, int weight) {
            this.weight = weight;
            this.index = index;
        }
    }
}