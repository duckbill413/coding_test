# 15565 귀여운 라이언

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = list(map(int, input().split()))

r = 0

left = 0
right = 0
answer = sys.maxsize

if A[left] == 1:
    r += 1

while left < N and right < N:
    if r < M:
        right += 1
        if right < N and A[right] == 1:
            r += 1
    else:
        if r == M:
            answer = min(answer, right - left + 1)
        if left < N and A[left] == 1:
            r -= 1
        left += 1

print(answer if answer != sys.maxsize else -1)