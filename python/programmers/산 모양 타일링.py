# 2024 KAKAO WINTER INTERNSHIP > 산 모양 타일링
def init(dp, dp_s, n, tops):
    for i in range(n):
        if tops[i] != 0:
            dp_s.add(2 * i + 1)

    dp[1][0] = 1
    dp[1][1] = 2

    if 1 in dp_s:
        dp[0][1] = 3


def solution(n, tops):
    size = 2 * n + 1
    dp = [[0 for j in range(size)] for i in range(2)]
    dp_s = set()

    init(dp, dp_s, n, tops)

    for i in range(2, size):
        if i % 2 == 0:
            if i - 1 in dp_s:
                dp[1][i] = dp[1][i - 2] + dp[0][i - 1]
            else:
                dp[1][i] = dp[1][i - 2] + dp[1][i - 1]
        else:
            if i - 2 in dp_s:
                dp[1][i] = dp[1][i - 1] + dp[0][i - 2]
            else:
                dp[1][i] = dp[1][i - 1] + dp[1][i - 2]
            if i in dp_s:
                dp[0][i] = dp[1][i] + dp[1][i - 1]
        dp[0][i] %= 10007
        dp[1][i] %= 10007

    return dp[1][size - 1] % 10007
