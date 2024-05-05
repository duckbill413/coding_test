package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra {
    private static List<List<int[]>> graph;
    private static int n, m;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }

        dijkstra(0);
        System.out.println(Arrays.toString(result));
    }

    public static void dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        result[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (result[cur[0]] < cur[1]) {
                continue;
            }

            for (int[] next : graph.get(cur[0])) {
                int nextCost = cur[1] + next[1];
                if (nextCost < result[next[0]]) {
                    result[next[0]] = nextCost;
                    pq.offer(new int[]{next[0], nextCost});
                }
            }
        }
    }
}
