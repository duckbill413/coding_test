# 1504. 특정한 최단 경로
import heapq
import sys

INF = int(1e9)
N, E = map(int, input().split())
graph = [[] for i in range(N + 1)]

for i in range(E):
    s, e, w = map(int, input().split())
    graph[s].append((e, w))
    graph[e].append((s, w))

v1, v2 = map(int, input().split())


def dijkstra(start, goal):
    distance = [INF] * (N + 1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)

        if distance[now] < dist:
            continue

        for next in graph[now]:
            cost = dist + next[1]
            if cost < distance[next[0]]:
                distance[next[0]] = cost
                heapq.heappush(q, (cost, next[0]))

    return distance[goal]


r1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N)
r2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N)

answer = min(r1, r2)

if answer < INF:
    print(answer)
else:
    print(-1)
