package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1956S2 {
    private static int INF = 987654321;
    private static int N, M;
    private static PriorityQueue<int[]> pq;
    private static List<List<int[]>> graph;
    private static int[][] distance;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(distance[i], INF);
            graph.add(new ArrayList<>());
        }
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{c, s, e});
            graph.get(s).add(new int[]{e, c});
            distance[s][e] = c;
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[1] == cur[2]) {
                System.out.println(cur[0]);
                System.exit(0);
            }

            if (cur[0] > distance[cur[1]][cur[2]]) continue;

            for (int[] next : graph.get(cur[2])) {
                int cost = cur[0] + next[1];
                if (cost < distance[cur[1]][next[0]]) {
                    distance[cur[1]][next[0]] = cost;
                    pq.add(new int[]{cost, cur[1], next[0]});
                }
            }
        }
        System.out.println(-1);
    }
}
