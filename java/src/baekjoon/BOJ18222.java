package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 18222 투에-모스 문자열
public class BOJ18222 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        int time = 0;
        long len = 1;
        while (len < N) {
            len <<= 1;
            time += 1;
        }

        int count = solution(N, time, 0);
        System.out.println(count % 2 == 0 ? 0 : 1);
    }

    public static int solution(long num, int time, int count) {
        if (num == 1 || num == 2) {
            if (num == 2) count += 1;
            return count;
        }

        if (num <= (long) Math.pow(2, time - 1) + (long) Math.pow(2, time - 2)) {
            return solution(num - (long) Math.pow(2, time - 2), time - 1, count);
        } else {
            return solution(num - (long) Math.pow(2, time - 1), time - 1, count + 1);
        }
    }
}
