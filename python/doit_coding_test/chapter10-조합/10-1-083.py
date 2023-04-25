# 1947 선물 전달하기
MOD = 1000000000
N = int(input())

dp = [0] * (1000000 + 1)
dp[1] = 0
dp[2] = 1

for i in range(3, N + 1):
    dp[i] = (i - 1) * (dp[i - 1] + dp[i - 2]) % MOD

print(dp[N])
