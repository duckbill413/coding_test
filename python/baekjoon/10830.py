# 10830 행렬 제곱

import sys
import copy

input = sys.stdin.readline

N, M = map(int, input().split())
A = [list(map(int, input().split())) for _ in range(N)]


def multiplex(a, b):
    B = [[0 for j in range(N)] for i in range(N)]

    for i in range(N):
        for j in range(N):
            for k in range(N):
                B[i][j] += (a[i][k] * b[k][j]) % 1000
            B[i][j] %= 1000

    return B


def powMatrix(B, M):
    if M <= 1:
        for i in range(N):
            for j in range(N):
                B[i][j] %= 1000
        return B

    B = powMatrix(B, M // 2)
    B = multiplex(B, B)

    if M % 2 != 0:
        B = multiplex(B, A)
    return B


B = copy.deepcopy(A)
B = powMatrix(B, M)
for i in range(N):
    print(*B[i], sep=" ")