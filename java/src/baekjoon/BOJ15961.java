package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 15961 회전 초밥 (메모리: 182276KB, 시간: 620ms)
public class BOJ15961 {
    private static int N, D, K, C;
    private static int[] belt;
    private static int[] sushi;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        belt = new int[N + K - 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            belt[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < K - 1; i++) {
            belt[i + N] = belt[i];
        }
        sushi = new int[30001];
        System.out.println(solution());
    }

    private static int solution() {
        int count = 0;
        int result = 0;
        for (int i = 0; i < K; i++) {
            if (sushi[belt[i]] == 0) {
                count += 1;
                result += 1;
            }
            sushi[belt[i]] += 1;
        }
        if (sushi[C] == 0) result += 1;

        int start = 0;
        int end = K - 1;

        while (end < N + K - 2) {
            end += 1;
            if (sushi[belt[end]] == 0) {
                count += 1;
            }
            sushi[belt[end]] += 1;
            if (sushi[belt[start]] == 1) {
                count -= 1;
            }
            sushi[belt[start]] -= 1;
            start += 1;

            if (sushi[C] == 0) result = Math.max(result, count + 1);
            else result = Math.max(result, count);
        }

        return result;
    }
}
