# 2143 두 배열의 합
import collections
import sys

input = sys.stdin.readline

T = int(input())
N = int(input())
A = list(map(int, input().split()))
M = int(input())
B = list(map(int, input().split()))

A_dict = collections.defaultdict(int)
for i in range(N):
    for j in range(i, N):
        A_dict[sum(A[i:j + 1])] += 1

answer = 0
for i in range(M):
    for j in range(i, M):
        answer += A_dict[T - sum(B[i:j + 1])]

print(answer)
