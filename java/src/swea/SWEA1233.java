package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1233 사칙연산 유효성 검사
public class SWEA1233 {
    private static final int T = 10;
    private static StringBuilder sb;
    private static int N;
    private static int position;
    private static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

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
            position = 0;
            answer = 1;
            inOrder(1, A);

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static void inOrder(int node, int[] A) {
        if (answer == 0) return;

        int left = node * 2;
        if (left <= N) inOrder(left, A);

        if (position % 2 == 1 && A[node] >= 48 && A[node] <= 57) {
            answer = 0;
        } else if (position % 2 == 0 && A[node] < 48 && A[node] > 57) {
            answer = 0;
        }
        position++;

        int right = node * 2 + 1;
        if (right <= N) inOrder(right, A);
    }
}
