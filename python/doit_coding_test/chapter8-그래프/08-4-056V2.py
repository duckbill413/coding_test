import heapq
import sys
input = sys.stdin.readline

V, E = map(int, input().split())
K = int(input())
distance = [sys.maxsize] * (V+1)
visited = [False] * (V+1)
myList = [[] for _ in range(V+1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    myList[u].append((v, w))

q = []
heapq.heappush(q, (0, K))
distance[K] = 0

while q:
    now_weight, now_node = heapq.heappop(q)

    if visited[now_node]:
        continue
    visited[now_node] = True

    for next_node, next_weight in myList[now_node]:
        if distance[now_node] + next_weight < distance[next_node]:
            distance[next_node] = distance[now_node] + next_weight
            heapq.heappush(q, (distance[next_node], next_node))

for i in range(1, V+1):
    if visited[i]:
        print(distance[i])
    else:
        print("INF")