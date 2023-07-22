# 3067 Coins
import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(T):
    N = int(input())
    coins = list(map(int, input().split()))
    M = int(input())

    dp = [0] * (M + 1)
    dp[0] = 1


    for i in range(N):
        for j in range(coins[i], M + 1):
            dp[j] += dp[j - coins[i]]

    print(dp[M])