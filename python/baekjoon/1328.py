# 1328 빌딩 순서 구하기
import sys

input = sys.stdin.readline
MOD = 1_000_000_007

N, L, R = map(int, input().split())

dp = [[[0 for k in range(101)] for j in range(101)] for i in range(101)]
dp[1][1][1] = 1

for k in range(2, N + 1):
    for i in range(1, L + 1):
        for j in range(1, R + 1):
            dp[k][i][j] = (dp[k - 1][i - 1][j] + dp[k - 1][i][j - 1] + (k - 2) * dp[k - 1][i][j]) % MOD

print(dp[N][L][R])