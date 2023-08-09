package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1233 사칙연산 유효성 검사
public class InOrder {
    private static final int T = 1;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            int[] A = new int[N + 1];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int node = st.nextToken().charAt(0);
                A[idx] = node;
            }
            inOrder(1, A);
        }
    }

    private static void inOrder(int node, int[] A) {
        int left = node * 2;
        if (left <= N) inOrder(left, A);

        if (A[node] >= 48 && A[node] <= 57) {
            System.out.printf("%d ", A[node] - '0');
        } else {
            System.out.printf("%c ", ((char) A[node]));
        }

        int right = node * 2 + 1;
        if (right <= N) inOrder(right, A);
    }
}
