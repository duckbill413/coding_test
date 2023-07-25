# 2473 세 용액
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

answer = int(1e10)
result = ()

A.sort()

for i in range(len(A) - 2):
    picked = A[i]

    start, end = i+1, len(A) - 1

    while start < end:
        sum = picked + A[start] + A[end]

        if answer > abs(sum):
            answer = abs(sum)
            result = (picked, A[start], A[end])

        if sum < 0:
            start += 1
        else:
            end -= 1

        if answer == 0:
            print(*sorted(result))
            exit()

print(*sorted(result))