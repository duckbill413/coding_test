package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 22865 가장 먼 곳
public class BOJ22865 {
    private static int N, M;
    private static int[] friends;
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        friends = new int[3];
        for (int i = 0; i < 3; i++) {
            friends[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        int max = 0;
        int answer = 0;
        dist = new int[N + 1];
        for (int d = 1; d <= N; d++) {
            dist[d] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < 3; i++) {
            int f = friends[i];
            dijkstra(f);
        }

        for (int d = 1; d <= N; d++) {
            if (max < dist[d]) {
                max = dist[d];
                answer = d;
            }
        }

        System.out.println(answer);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.weight > dist[now.id]) {
                continue;
            }

            for (Node next : graph.get(now.id)) {
                int cost = dist[now.id] + next.weight;
                if (dist[next.id] > cost) {
                    pq.add(next);
                    dist[next.id] = cost;
                }
            }
        }
    }

    private static class Node {
        private int id;
        private int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }
    }
}
