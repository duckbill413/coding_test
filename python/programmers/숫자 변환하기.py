def is_valid(num):
    global X, Y
    return X <= num <= Y


def solution(x, y, n):
    global X, Y
    X, Y = x, y
    INF = 987654321
    dp = [INF] * (y + 1)
    dp[x] = 0

    for i in range(x, y + 1):
        if is_valid(i - n):
            dp[i] = min(dp[i], dp[i - n] + 1)
        if i % 2 == 0 and is_valid(i // 2):
            dp[i] = min(dp[i], dp[i // 2] + 1)
        if i % 3 == 0 and is_valid(i // 3):
            dp[i] = min(dp[i], dp[i // 3] + 1)

    return dp[y] if dp[y] != INF else -1
