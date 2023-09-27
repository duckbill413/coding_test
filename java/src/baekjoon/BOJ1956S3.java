package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1956S3 {

    private static int INF = 987654321;
    private static int N, M;
    private static List<List<int[]>> graph;
    private static int[] distance;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }

        answer = INF;
        distance = new int[N + 1];
        for (int start = 1; start <= N; start++) {
            Arrays.fill(distance, INF);
            answer = Math.min(answer, dijkstra(start));
        }

        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, start});
        boolean flag = false;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] > distance[cur[1]]) continue;
            if (cur[1] == start && flag) {
                return cur[0];
            } else if (cur[1] == start) {
                flag = true;
            }

            for (int[] next : graph.get(cur[1])) {
                int cost = cur[0] + next[1];
                if (cost < distance[next[0]]) {
                    distance[next[0]] = cost;
                    pq.add(new int[]{cost, next[0]});
                }
            }
        }

        return INF;
    }
}
