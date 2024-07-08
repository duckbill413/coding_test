package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P42861 {
    private int[] parents;

    private int findParent(int x) {
        if (x == parents[x]) {
            return x;
        }

        return parents[x] = findParent(parents[x]);
    }

    private void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        parents[a] = b;
    }

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        q.addAll(Arrays.asList(costs));

        int answer = 0;
        while (!q.isEmpty()) {
            int[] cost = q.poll();

            if (findParent(cost[0]) != findParent(cost[1])) {
                answer += cost[2];
                unionParent(cost[0], cost[1]);
            }
        }

        return answer;
    }
}
