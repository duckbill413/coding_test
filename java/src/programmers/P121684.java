package programmers;

import java.util.ArrayList;
import java.util.List;

public class P121684 {
    private int[][] A;
    private int[] id;
    private boolean[] visited;
    private List<int[]> teams;
    private int answer;

    public void permutation(int depth, boolean[] visited, int[] result) {
        if (depth == result.length) {
            for (int[] team : teams) {
                int tmp = 0;
                for (int i = 0; i < result.length; i++) {
                    tmp += A[team[i]][result[i]];
                }
                answer = Math.max(answer, tmp);
            }
            return;
        }

        for (int i = 0; i < result.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                permutation(depth + 1, visited, result);
                visited[i] = false;
            }
        }
    }

    public void combination(int start, int depth, int target) {
        if (depth == target) {
            int idx = 0;
            int[] selected = new int[A[0].length]; // 선택된 학생
            for (int i = 0; i < A.length; i++) {
                if (visited[i]) {
                    selected[idx++] = id[i];
                }
            }

            teams.add(selected);
            return;
        }

        for (int i = start; i < A.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                combination(i + 1, depth + 1, target);
                visited[i] = false;
            }
        }
    }

    public int solution(int[][] ability) {
        A = ability;
        id = new int[ability.length];
        visited = new boolean[ability.length];
        answer = 0;
        for (int i = 0; i < ability.length; i++) {
            id[i] = i;
        }
        teams = new ArrayList<>();

        // 짤 수 있는 팀의 조합 구하기
        combination(0, 0, ability[0].length);
        // 팀에 대하여 만들 수 있는 종목 선택의 종류
        permutation(0, new boolean[ability[0].length], new int[ability[0].length]);


        return answer;
    }

    public static void main(String[] args) {
        int [][] ability = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        System.out.println(new P121684().solution(ability));
    }
}
