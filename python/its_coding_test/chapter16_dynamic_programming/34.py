# 34. 병사 배치하기

n = int(input())
marines = list(map(int, input().split()))

dp = [1] * n
for i in range(n):
    for j in range(i):
        dp[i] = max(dp[i], dp[j]+1) if marines[j] > marines[i] else dp[i]

length = max(dp)
answer = n - length
print(answer)
