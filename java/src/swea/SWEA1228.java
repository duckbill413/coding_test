package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 1228 암호문1
public class SWEA1228 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= 10; test_case++) {
            LinkedList<Integer> ll = new LinkedList<>();

            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ll.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                st.nextToken();
                int start = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                for (int i = start; i < start + len; i++) {
                    ll.add(i, Integer.parseInt(st.nextToken()));
                }
            }

            sb.append("#").append(test_case).append(" ");
            for (int i = 0; i < 10; i++) {
                sb.append(ll.pollFirst()).append(" ");
                if (ll.isEmpty()) {
                    break;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
