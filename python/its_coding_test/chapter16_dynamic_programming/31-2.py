# 31. 금광

for tc in range(int(input())):
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    dp = []
    for i in range(n):
        dp.append(array[i*m:i*m+m])

    for j in range(1, m):
        for i in range(n):
            left_up = dp[i-1][j-1] if i != 0 else 0
            left_mid = dp[i][j-1]
            left_down = dp[i+1][j-1] if i != n-1 else 0

            dp[i][j] = dp[i][j] + max(left_up, left_mid, left_down)

    answer = 0
    for i in range(n):
        answer = max(answer, dp[i][m-1])

    print(answer)