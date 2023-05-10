# 2193 이친수 구하기
import sys
input = sys.stdin.readline

N = int(input())

dp = [[0 for j in range(N+1)] for i in range(2)]

dp[0][1] = 0
dp[1][1] = 1

for i in range(2, N+1):
    dp[0][i] = dp[0][i-1] + dp[1][i-1]
    dp[1][i] = dp[0][i-1]

print(dp[0][i] + dp[1][i])