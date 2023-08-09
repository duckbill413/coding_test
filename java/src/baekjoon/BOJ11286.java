package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 11286 절댓값 힙 (메모리: 29084kb, 시간 444ms)
public class BOJ11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Number> pq = new PriorityQueue<>((o1, o2) -> {
            // 절댓값이 같다면 숫자로 오름차순
            if (o1.abs == o2.abs) {
                return o1.num - o2.num;
            }
            // 절댓값으로 오름차순
            return o1.abs - o2.abs;
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(new Number(num, Math.abs(num)));
            } else {
                if (!pq.isEmpty()) sb.append(pq.poll().num).append("\n");
                else sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static class Number {
        private int num;
        private int abs;

        public Number(int num, int abs) {
            this.num = num;
            this.abs = abs;
        }
    }
}
