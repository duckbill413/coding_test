# 40. 숨바꼭질
import heapq

INF = int(1e9)
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
distance = [INF] * (n+1)

for i in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

start = 1
q = []
heapq.heappush(q, (0, start))
distance[start] = 0

while q:
    cost, now = heapq.heappop(q)

    if distance[now] < cost:
        continue

    for next in graph[now]:
        c = cost + 1
        if c < distance[next]:
            distance[next] = c
            heapq.heappush(q, (c, next))

maximum = max(distance[1:])
print(distance.index(maximum), maximum, distance.count(maximum))
'''
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
'''