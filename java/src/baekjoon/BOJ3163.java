package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 3163 떨어지는 개미
public class BOJ3163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 개미의 수
            int L = Integer.parseInt(st.nextToken()); // 막대기의 길이
            int K = Integer.parseInt(st.nextToken()); // k 번째로 떨어지는 개미

            Deque<Integer> dq = new ArrayDeque<>();
            Pair[] time = new Pair[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int position = Integer.parseInt(st.nextToken());
                int id = Integer.parseInt(st.nextToken());

                if (id > 0) {
                    time[i] = new Pair(L - position + 1, true);
                } else {
                    time[i] = new Pair(position + 1, false);
                }
                dq.addLast(id);
            }

            Arrays.sort(time, Comparator.comparingInt(Pair::getTime));

            int answer = 0;
            for (int k = 0; k < K; k++) {
                Pair cur = time[k];

                // k < N - 1이면서 소요시간이 다음 것과 같으면서 같다면
                if (k < N - 1 && cur.time == time[k + 1].time) {
                    // 현재 d가 오른쪽일때 만약 왼쪽의 id가 더 작으면 변경 필요
                    if (cur.d && dq.peekFirst() < dq.peekLast()) {
                        cur.d = false;
                        time[k + 1].d = true;
                    }
                    // 현재 d가 왼쪽일때 만약 오른쪽의 id가 더 작으면 변경 필요
                    else if (!cur.d && dq.peekFirst() > dq.peekLast()) {
                        cur.d = true;
                        time[k + 1].d = false;
                    }
                }
                if (cur.d) {
                    answer = dq.pollLast();
                } else {
                    answer = dq.pollFirst();
                }
            }

            System.out.println(answer);
        }
    }

    private static class Pair {
        int time;
        boolean d;

        public Pair(int time, boolean d) {
            this.time = time;
            this.d = d;
        }

        public int getTime() {
            return time;
        }
    }
}
