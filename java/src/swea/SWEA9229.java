package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9229 한빈이와 Spot Mart
public class SWEA9229 {
    private static int TC, N, M;
    private static Integer[] A;

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TC = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= TC; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            A = new Integer[N];
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);

            int max = -1;
            int start = 0;
            int end = N - 1;
            while (start < end) {
                int sum = A[start] + A[end];

                if (sum > M) {
                    end--;
                } else if (sum < M) {
                    max = Math.max(max, sum);
                    start++;
                } else {
                    max = M;
                    break;
                }
            }
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
