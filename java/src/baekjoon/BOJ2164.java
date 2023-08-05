package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 2164 카드2
public class BOJ2164 {
    private static Deque<Integer> dq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        dq = new ArrayDeque<>();
        for (int n = 1; n <= N; n++) {
            dq.offerLast(n);
        }

        while (true) {
            if (dq.size() == 1) {
                break;
            }
            dq.pollFirst();
            dq.offerLast(dq.pollFirst());
        }

        System.out.println(dq.pollFirst());
    }
}
