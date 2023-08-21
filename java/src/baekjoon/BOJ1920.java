package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    private static int N, M;
    private static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            int find = Integer.parseInt(st.nextToken());
            if (findNumber(find)) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean findNumber(int find) {
        int start = 0;
        int end = N - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] < find) {
                start = mid + 1;
            } else if (A[mid] > find) {
                end = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
