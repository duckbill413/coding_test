# 2876 그래픽스 퀴즈

import sys

input = sys.stdin.readline

N = int(input())
scores = [list(map(int, input().split())) for _ in range(N)]
dp = [[1 for _ in range(2)] for i in range(N)]
max_length = [1] * 6
max_length[0] = 0

for i in range(1, N):
    for j in range(2):
        if scores[i][j] == scores[i - 1][j]:
            dp[i][j] = dp[i - 1][j] + 1
        if scores[i][j] == scores[i - 1][(j + 1) % 2]:
            dp[i][j] = max(dp[i][j], dp[i - 1][(j + 1) % 2] + 1)
        max_length[scores[i][j]] = max(max_length[scores[i][j]], dp[i][j])

find = max(max_length)
print(f'{find} {max_length.index(find)}')