package programmers;

import java.util.Arrays;

public class P121685 {

    private String search(int n, int p) {
        int start = 1;
        int end = (int) Math.pow(4, n - 1);

        int size = end;
        while (start < end) {
            int q = size / 4;

            if (p < start + q) {
                return "RR";
            } else if (end - q < p) {
                return "rr";
            } else {
                if (start + q <= p && p < start + 2 * q) {
                    start += q;
                    end -= q * 2;
                } else {
                    start += q * 2;
                    end -= q;
                }
                size /= 4;
            }
        }

        return "Rr";
    }

    public String[] solution(int[][] queries) {
        String[] answer = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            answer[i] = search(queries[i][0], queries[i][1]);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] queries = {{3, 1}, {2, 3}, {3, 9}};
        System.out.println(Arrays.toString(new P121685().solution(queries)));
    }
}
