# 33. 퇴사

n = int(input())
t, p = [], []
for i in range(n):
    x, y = map(int, input().split())
    t.append(x)
    p.append(y)

dp = [0] * (n+1)
max_value = 0
for i in range(n-1, -1, -1):
    time = t[i] + i

    if time <= n:
        dp[i] = max(p[i] + dp[time], max_value)
        max_value = dp[i]
    else:
        dp[i] = max_value

print(dp[0])