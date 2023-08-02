package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ22857 {
    private static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] A = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        dp = new int[K+2][N+1];
        for (int i=1; i<K+2; i++){
            for (int j=1; j<=N; j++){
                // 짝수
                if (A[j-1] % 2 == 0){
                    dp[i][j] = dp[i][j-1] + 1;
                } else { // 홀수
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
            }
        }

        int answer = Arrays.stream(dp[K+1]).max().getAsInt();
        System.out.println(answer);
    }
}
