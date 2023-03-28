# 1509
import sys

input = lambda: sys.stdin.readline().rstrip()
MAX_VALUE = int(1e9)
text = input()
length = len(text)

dp = [MAX_VALUE for _ in range(length + 1)]
dp[-1] = 0
is_p = [[0 for j in range(length)] for _ in range(length)]

for i in range(length):
    is_p[i][i] = 1

for i in range(1, length):  # 길이 2 짜리 팰린드롬
    if text[i] == text[i - 1]:
        is_p[i - 1][i] = 1

for l in range(3, length + 1):  # 길이 3~length 팰린드롬
    for start in range(length - l + 1):
        end = start + l - 1
        if text[start] == text[end] and is_p[start + 1][end - 1]:
            # 처음과 끝이 같고, 그 사이가 팰린드롬이면
            is_p[start][end] = 1  # start ~ end 도 팰린드롬

for end in range(length):
    for start in range(end + 1):
        if is_p[start][end]:
            dp[end] = min(dp[end], dp[start - 1] + 1)
        else:
            dp[end] = min(dp[end], dp[end - 1] + 1)

print(dp[length - 1])
