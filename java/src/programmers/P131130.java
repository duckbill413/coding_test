package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P131130 {
    private int N;
    private int[] C;

    private void game(int target, List<Integer> group, boolean[] visited) {
        if (visited[target - 1]) {
            return;
        }

        visited[target - 1] = true;
        group.add(target);
        game(C[target - 1], group, visited);
    }

    public int solution(int[] cards) {
        N = cards.length;
        C = cards;

        int answer = 0;

        for (int i = 0; i < N / 2 + 1; i++) {
            boolean[] visited = new boolean[N];
            List<Integer> group1 = new ArrayList<>();
            game(C[i], group1, visited);

            for (int j = 0; j < N; j++) {
                if (!(visited[C[j] - 1])) {
                    List<Integer> group2 = new ArrayList<>();
                    game(C[j], group2, Arrays.copyOf(visited, visited.length));

                    answer = Math.max(answer, group1.size() * group2.size());
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        P131130 p = new P131130();
        System.out.println(p.solution(cards));
    }
}
