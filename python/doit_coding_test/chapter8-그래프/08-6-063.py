# 1389 케빈 베이컨의 6단계 법칙

import sys
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[sys.maxsize for i in range(N+1)] for j in range(N+1)]

for i in range(N+1):
    graph[i][i] = 0

for _ in range(M):
    s, e = map(int, input().split())
    graph[s][e] = 1
    graph[e][s] = 1

for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

minium = sys.maxsize
answer = None

for i in range(1, N+1):
    if minium > sum(graph[i][1:]):
        minium = sum(graph[i][1:])
        answer = i

print(answer)