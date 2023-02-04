import sys

INF = int(1e9)

input = sys.stdin.readline

n = int(input())
m = int(input())

graph = [[INF] * (n+1) for i in range(n+1)]

for i in range(n+1):
    graph[i][i] = 0

for i in range(m):
    s, e, c = map(int, input().split())
    graph[s][e] = c

for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print("INFINITY", end=' ')
        else:
            print(graph[a][b], end=' ')
        print()