# 2470 두 용액

# 2468 용액

import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

start = 0
end = N - 1
answer = int(3e9)

A.sort()

a = A[start]
b = A[end]
while start < end:
    tmp = A[start] + A[end]
    if abs(tmp) < abs(answer):
        a = A[start]
        b = A[end]
        answer = tmp
        if answer == 0:
            break

    if tmp > 0:
        end -= 1
    else:
        start += 1
print(a, b)
