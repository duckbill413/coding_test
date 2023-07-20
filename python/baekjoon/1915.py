# 1915 가장 큰 정사각형 찾기

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(map(int, input().strip())) for _ in range(N)]
A.insert(0, [0] * M)
for i in range(N + 1):
    A[i].insert(0, 0)

answer = 0
for i in range(1, N + 1):
    for j in range(1, M + 1):
        if A[i][j] == 1:
            A[i][j] = min(A[i - 1][j - 1], A[i - 1][j], A[i][j - 1]) + 1
            answer = max(answer, A[i][j])

print(answer ** 2)
