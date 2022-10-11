# 12854. 평범한 배낭

n, k = map(int, input().split())
dp = [0] * (k+1)

for i in range(n):
    w, v = map(int, input().split())
    for j in range(k, w-1, -1):
        dp[j] = max(dp[j], dp[j-w] + v)

print(dp[k])