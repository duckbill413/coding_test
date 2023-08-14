package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 22234 가희와 은행
public class BOJ22234 {
    private static int N, T, W, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        Queue<Customer> q = new LinkedList<>();
        PriorityQueue<Customer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.enter));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Customer customer = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            q.add(customer);
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            Customer customer = new Customer(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            pq.add(customer);
        }

        StringBuilder sb = new StringBuilder();

        int time = 0;
        while (!q.isEmpty()) {
            Customer customer = q.poll();

            for (int t = 0; t < Math.min(customer.time, T); t++) {
                if (time >= W) break;
                sb.append(customer.id).append("\n");
                time++;
            }
            if (time >= W) break;

            while (!pq.isEmpty() && pq.peek().enter <= time) {
                q.add(pq.poll());
            }
            if (customer.time > T) {
                customer.time -= T;
                q.add(customer);
            }
        }
        System.out.print(sb);
    }

    private static class Customer {
        int id, time, enter;

        public Customer(int id, int time) {
            this.id = id;
            this.time = time;
            this.enter = 0;
        }

        public Customer(int id, int time, int enter) {
            this.id = id;
            this.time = time;
            this.enter = enter;
        }
    }
}
