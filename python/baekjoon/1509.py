# 1509 팰린드롬 분할
import sys

input = sys.stdin.readline
MAX_VALUE = int(1e9)

text = input().rstrip()
answer = MAX_VALUE
size = len(text)


def checkPalindrome(isPalindrome, text, start, end):
    size = len(text)
    while 0 <= start and end < size and text[start] == text[end]:
        isPalindrome[start][end] = True
        start -= 1
        end += 1


def getIsPalindrome(text):
    size = len(text)
    isPalindrome = [[False] * size for _ in range(size)]

    for start in range(size):
        # 홀수
        checkPalindrome(isPalindrome, text, start, start)
        # 짝수
        checkPalindrome(isPalindrome, text, start, start + 1)

    return isPalindrome


isPalindrome = getIsPalindrome(text)

dp = [1] * size
for end in range(1, size):
    dp[end] = dp[end - 1] + 1
    for start in range(end):
        if isPalindrome[start][end]:
            if start == 0:
                dp[end] = 1
                break
            else:
                dp[end] = min(dp[end], dp[start - 1] + 1)

print(dp[size - 1])
