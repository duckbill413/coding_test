package programmers;

public class P12907 {
    static final long INF = 1000000007;

    public long solution(int n, int[] money) {
        long[] DP = new long[n + 1];

        for (int cur : money) {
            if (cur > n) continue;
            DP[cur]++;
            for (int j = 1; j <= n; j++) {
                if (j - cur >= 0) {
                    DP[j] += DP[j - cur];
                    DP[j] %= INF;
                }
            }
        }
        return DP[n];
    }
}
