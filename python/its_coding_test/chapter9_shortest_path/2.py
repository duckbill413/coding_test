# 2. 미래 도시
import sys

input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())
graph = [[INF] * (N+1) for i in range(N+1)]

# 자기 자신의 비용
for i in range(N+1):
    graph[i][i] = 0

# 각 간선의 정보를 이용하여 그값으로 초기화
for i in range(M):
    s, e, = map(int, input().split())
    graph[s][e] = 1
    graph[e][s] = 1

X, K = map(int, input().split())

# start = 1번 도시 부터
for k in range(1, N+1):
    for a in range(1, N+1):
        for b in range(1, N+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]) # a->b 경로와 a->k->b 경로 비용 비교

distance = graph[1][K] + graph[K][X]

if distance >= INF:
    print(-1)
else:
    print(distance)


'''
ex1)
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

ex2)
4 2
1 3
2 4
3 4
'''