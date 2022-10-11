# 12865. 평범한 배낭

N, K = map(int, input().split())
dp = [[0] * (K+1) for i in range(N+1)]

for i in range(1, N+1):
    W, V = map(int, input().split())
    for j in range(1, K+1):
        if W <= j:
            dp[i][j] = max(dp[i-1][j], V+dp[i-1][j-W])
        else:
            dp[i][j] = dp[i-1][j]

print(dp[N][K])

'''
4 7
6 13
4 8
3 6
5 12
'''