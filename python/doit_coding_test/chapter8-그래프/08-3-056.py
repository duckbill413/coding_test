# 1753 최단 경로 구하기
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

V, E = map(int, input().split())
start = int(input())

graph = [[] for _ in range(V+1)]
result = [INF] * (V+1)

for i in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

q = []
heapq.heappush(q, (0, start))
result[start] = 0

while q:
    now_weight, now_node = heapq.heappop(q)

    if result[now_node] < now_weight:
        continue

    for next_node, next_weight in graph[now_node]:
        weight = result[now_node] + next_weight
        if weight < result[next_node]:
            result[next_node] = weight
            heapq.heappush(q, (weight, next_node))

for i in range(1, V+1):
    if result[i] == INF:
        print("INF")
    else:
        print(result[i])