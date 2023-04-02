# 1854 K번째 최단 경로 구하기
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

N, M, K = map(int, input().split())
graph = [[] for _ in range(N+1)]
distance = [[INF] * K for _ in range(N+1)]

for i in range(M):
    a, b, c = map(int, input().split())
    graph[a].append((b, c))

start = 1 # 시작은 1번 도시에서 시작

q = []
heapq.heappush(q, (0, start))
distance[start][0] = 0

while q:
    now_weight, now_node = heapq.heappop(q)

    for next_node, next_weight in graph[now_node]:
        weight = now_weight + next_weight
        if weight < distance[next_node][K-1]:
            distance[next_node][K-1] = weight
            distance[next_node].sort()
            heapq.heappush(q, (weight, next_node))

for i in range(1, N+1):
    if distance[i][K-1] == INF:
        print(-1)
    else:
        print(distance[i][K-1])