package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P121686 {
    public long[] solution(int[][] program) {
        // 호출순서에 대하여 정렬
        Arrays.sort(program, Comparator.comparingInt(a -> a[1]));

        // 프로그램을 우선순위(asc), 호출순서(asc)에 대하여 정렬하여 pq 에 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        long[] answer = new long[11];

        int idx = 0;
        while (idx < program.length || !pq.isEmpty()) {
            // 호출시간이 현재시간 보다 같거나 작은 것 전부 pq 에 입력
            while (idx < program.length && program[idx][1] <= answer[0]) {
                pq.add(program[idx++]);
            }
            // 만약 들어간게 아무 것도 없는 경우 현재 시간을 변경
            if (pq.isEmpty()) {
                answer[0] = program[idx][1]; // 현재 시간을 호출 시간으로 맞추기
                continue;
            }

            int[] cur = pq.poll();
            answer[cur[0]] += answer[0] - cur[1]; // 대기시간 증가
            answer[0] += cur[2]; // 종료시간 증가
        }

        return answer;
    }
}
