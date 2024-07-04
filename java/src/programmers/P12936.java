package programmers;

import java.util.ArrayList;
import java.util.List;

public class P12936 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long fac = 1l;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }

        k--;
        int idx = 0;
        while (idx < n) {
            fac = fac / (n - idx);
            answer[idx++] = list.remove((int) (k / fac));
            k = k % fac;
        }

        return answer;
    }
}
