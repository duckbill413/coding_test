import sys

input = sys.stdin.readline
K, N = map(int, input().split())
dp = []
move = []
for i in range(N - 1):
    data = list(map(int, input().split()))
    dp.append(data[:K])
    move.append(data[K])

dp.append(list(map(int, input().split())))

for i in range(N-1):
    tmp = min(dp[i])

    for j in range(K):
        if i == j:
            dp[i+1][j] += dp[i][j]
        else:
            dp[i+1][j] += min(dp[i][j], tmp + move[i])

print(min(dp[-1]))