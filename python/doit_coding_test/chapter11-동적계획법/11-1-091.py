# 1915 가장 큰 정사각형

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
dp = [[0 for j in range(1001)] for i in range(1001)]
answer = 0

for i in range(N):
    numbers = list(input())
    for j in range(M):
        dp[i][j] = int(numbers[j])
        if dp[i][j] == 1 and i > 0 and j > 0:
            dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
            answer = max(answer, dp[i][j])

print(answer ** 2)
