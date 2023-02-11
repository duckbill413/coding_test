# 1167 트리의 지름 구하기
import collections
import sys

input = sys.stdin.readline

V = int(input())
edges = [[] for _ in range(V + 1)]

for i in range(V):
    edge = list(map(int, input().split()))
    index = 0
    s = edge[index]
    index += 1
    while True:
        e = edge[index]
        if e == -1:
            break

        c = edge[index + 1]
        edges[s].append((e, c))
        index += 2

distance = [0] * (V + 1)
visited = [False] * (V + 1)


def bfs(v):
    q = collections.deque([v])
    visited[v] = True

    while q:
        now = q.popleft()
        for next in edges[now]:
            e, c = next
            if not visited[e]:
                visited[e] = True
                distance[e] = c + distance[now]
                q.append(e)

bfs(1)
max_idx = distance.index(max(distance))

distance = [0] * (V+1)
visited = [False] * (V+1)
bfs(max_idx)
print(max(distance))