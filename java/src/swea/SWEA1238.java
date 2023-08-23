package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1238 Contact (메모리: 21036kb, 시간: 116ms)
public class SWEA1238 {
    private static final int T = 10;
    private static Map<Integer, List<Integer>> graph;
    private static Map<Integer, Integer> visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            graph = new TreeMap<>();
            visited = new TreeMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i += 2) {
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                if (!graph.containsKey(s)) {
                    graph.put(s, new ArrayList<>());
                }
                if (!graph.containsKey(e)) {
                    graph.put(e, new ArrayList<>());
                }
                graph.get(s).add(e);
                visited.put(s, 0);
                visited.put(e, 0);
            }

            bfs(M);

            int id = M;
            int max = 1;
            for (Integer key : visited.keySet()) {
                if (visited.get(key) != 0) {
                    if (max <= visited.get(key)) {
                        if (max < visited.get(key)) {
                            id = key;
                            max = visited.get(key);
                        } else if (id < key) {
                            id = key;
                        }
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(id).append("\n");
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited.put(start, 1);

        while (!q.isEmpty()) {
            Integer cur = q.poll();

            for (Integer next : graph.get(cur)) {
                if (visited.get(next) == 0) {
                    visited.put(next, visited.get(cur) + 1);
                    q.add(next);
                }
            }
        }
    }
}
