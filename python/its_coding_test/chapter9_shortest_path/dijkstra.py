import heapq
import sys

input = sys.stdin.readline

INF = int(1e9)

n, m = map(int, input().split())
start = int(input())

graph = [[] for i in range(n+1)]
dist = [INF] * (n + 1)

for i in range(m):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))
    graph[e].append((s, c))

def dijstra(start):
    q = []
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        cost, now = heapq.heappop(q)

        if dist[now] < cost:
            continue
            
        if next in graph[now]:
            c = cost + next[1]
            if c < dist[next[1]]:
                dist[next[0]] = c
                heapq.heappush(q, (c, next[0]))