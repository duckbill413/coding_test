package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 3040 백설 공주와 일곱 난쟁이 (메모리: 11484kb, 시간: 72ms)
public class BOJ3040 {
    private static final int FIND = 100;
    private static final int NUM = 9;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[NUM];
        int[] O = new int[NUM];
        int total = 0;
        for (int i = 0; i < NUM; i++) {
            A[i] = O[i] = Integer.parseInt(br.readLine());
            total += A[`i];
        }

        Arrays.sort(A);

        int start = 0;
        int end = NUM - 1;
        while (start < end) {
            int sum = A[start] + A[end];

            if (total - sum < FIND) {
                end -= 1;
            } else if (total - sum > FIND) {
                start += 1;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUM; i++) {
            if (O[i] == A[start] || O[i] == A[end]) continue;
            sb.append(O[i]).append("\n");
        }
        System.out.println(sb);
    }
}
