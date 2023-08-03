package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2023 {
    private static int N;
    private static StringBuilder sb;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();

        dfs(2);
        dfs(3);
        dfs(5);
        dfs(7);
        System.out.println(sb);
    }

    private static boolean isPrime(int num) {
        for (int n = 2; n < (int) Math.sqrt(num) + 1; n++) {
            if (num % n == 0) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int num) {
        if (num >= Math.pow(10, N-1)) {
            if (num >= Math.pow(10, N)){
                return;
            }
            sb.append(num).append('\n');
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0)
                continue;

            if (isPrime(num * 10 + i)) {
                dfs(num * 10 + i);
            }
        }
    }
}
