# 1916 최소 비용 구하기
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

N = int(input())
M = int(input())

result = [INF] * (N+1)
graph = [[] for _ in range(N+1)]

for i in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

start, end = map(int, input().split())
result[start] = 0

q = []
heapq.heappush(q, (0, start))
while q:
    now_weight, now_node = heapq.heappop(q)

    if result[now_node] < now_weight:
        continue

    for next_node, next_weight in graph[now_node]:
        weight = result[now_node] + next_weight
        if weight < result[next_node]:
            result[next_node] = weight
            heapq.heappush(q, (weight, next_node))

print(result[end])