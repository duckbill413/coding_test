# 1, 2, 3 더하기 5

import sys

input = sys.stdin.readline

T = int(input())
MOD = 1_000_000_009

numbers = [int(input()) for _ in range(T)]

dp = [[0] * 4 for _ in range(max(numbers) + 1)]

dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1

for i in range(4, max(numbers) + 1):
    dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD
    dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD
    dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD


def get_answer(index):
    return (dp[index][1] + dp[index][2] + dp[index][3]) % MOD


for i in range(T):
    print(get_answer(numbers[i]))
