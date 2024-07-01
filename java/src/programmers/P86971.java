package programmers;

import java.util.ArrayList;
import java.util.List;

class P86971 {
    private static List<List<Integer>> graph;

    private void connect(int start, int target, int[] disconnect, int[] visited) {
        visited[start] = target;

        for (Integer next : graph.get(start)) {

            if ((start == disconnect[0] && next == disconnect[1]) ||
                (start == disconnect[1] && next == disconnect[0])) {
                continue;
            }

            if (visited[next] == 0) {
                connect(next, target, disconnect, visited);
            }
        }
    }

    public int solution(int n, int[][] wires) {

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int answer = 9999;
        for (int[] wire : wires) {
            int[] visited = new int[n + 1];
            connect(1, 1, wire, visited);

            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0) {
                    connect(j, 2, wire, visited);
                    break;
                }
            }

            int a = 0, b = 0;
            for (int k = 1; k <= n; k++) {
                if (visited[k] == 1) {
                    a++;
                } else if (visited[k] == 2) {
                    b++;
                }
            }
            // System.out.println(a + " " + b + " " + Arrays.toString(visited));
            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(new P86971().solution(n, wires));
    }
}