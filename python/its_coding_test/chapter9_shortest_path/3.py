# 3. 전보
N, M, C = map(int, input().split())
INF = int(1e9)

import sys

input = sys.stdin.readline

graph = [[] for i in range(N + 1)]
distance = [INF] * (N + 1)

for i in range(M):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))


def dijkstra(start):
    q = []
    import heapq
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


dijkstra(C)

count = 0
max_distance = 0

for i in range(1, N + 1):
    if distance[i] == INF:
        continue

    count += 1
    max_distance = max(max_distance, distance[i])

print(count - 1, max_distance)

'''
3 2 1
1 2 4
1 3 2
'''