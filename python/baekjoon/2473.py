# 2473 세 용액
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

answer = int(1e10)
result = ()

A.sort()

while len(A) >= 3:
    picked = A.pop()
    small = int(1e10)
    r = ()
    flag = False

    start, end = 0, len(A) - 1

    while start < end:
        sum = picked + A[start] + A[end]

        if small > abs(sum):
            small = abs(sum)
            r = (picked, A[start], A[end])
            flag = True



        if sum < 0:
            start += 1
        else:
            end -= 1

        if answer == 0:
            print(*sorted(result))
            exit()

print(*sorted(result))
