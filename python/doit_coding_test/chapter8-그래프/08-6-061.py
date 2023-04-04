# 11404 가장 빠른 버스 노선 구하기

import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

distance = [[sys.maxsize] * (N + 1) for _ in range(N + 1)]
for i in range(N + 1):
    distance[i][i] = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    if distance[a][b] > c:
        distance[a][b] = c

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            distance[a][b] = min(distance[a][b], distance[a][k] + distance[k][b])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if distance[i][j] == sys.maxsize:
            print(0, end=' ')
        else:
            print(distance[i][j], end=' ')
    print()
