package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class P42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<int[]> bridge = new ArrayDeque<>();

        int answer = 0;

        int idx = 0;
        int now_weight = 0;
        while (idx < truck_weights.length || !bridge.isEmpty()) {
            if (idx < truck_weights.length && now_weight + truck_weights[idx] <= weight) {
                now_weight += truck_weights[idx];
                bridge.add(new int[]{truck_weights[idx], bridge_length});
                idx += 1;
            }

            if (!bridge.isEmpty()) {
                for (int[] b : bridge) {
                    b[1] -= 1;
                }

                if (bridge.peek()[1] == 0) {
                    int[] out = bridge.poll();
                    now_weight -= out[0];
                }
            }

            answer += 1;
        }

        return answer + 1;
    }

    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        System.out.println(new P42583().solution(bridge_length, weight, truck_weights));
        // answer
        // 8
    }
}
