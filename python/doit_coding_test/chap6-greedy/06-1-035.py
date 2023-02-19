# 1931 회의실 배정하기
import sys
input = sys.stdin.readline

N = int(input())
A = []
for i in range(N):
    a, b = map(int, input().split())
    A.append((b, a))

A.sort()

answer = 0
end = -1
for i in range(N):
    if A[i][1] >= end:
        answer += 1
        end = A[i][0]

print(answer)