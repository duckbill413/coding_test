package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22234 {
    private static int N, T, W, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        PriorityQueue<Customer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.enter));
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Customer customer = new Customer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pq.add(customer);
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
        for (int time = 0; time < W; time++) {
            Customer customer;
            if (pq.peek().enter <= time) {
                customer = pq.poll();
            } else {
                continue;
            }

            int need = Math.min(customer.time, T);
            if (time + need > W) {
                need = W - time;
            }
            for (int t = 0; t < need; t++) {
                sb.append(customer.id).append("\n");
            }

            if (customer.time > T) {
                customer.time -= T;
                customer.enter = time + T;
                pq.add(customer);
            }

            time += need - 1;
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
