package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 1225. 암호생성기
public class SWEA1225 {
    private static final int T = 10;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                dq.offerLast(Integer.parseInt(st.nextToken()));
            }

            int count = 1;
            while (true) {
                if (count == 6) {
                    count = 1;
                }
                int first = dq.removeFirst();
                if (first > count) {
                    dq.offerLast(first - count);
                } else {
                    dq.offerLast(0);
                    break;
                }
                count++;
            }
            sb.append("#").append(N);
            while (!dq.isEmpty()) {
                sb.append(" ").append(dq.pollFirst());
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
