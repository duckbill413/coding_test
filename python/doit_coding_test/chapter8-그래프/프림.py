# 프림 알고리즘
# 1197 최소 신장 트리 구하기
# ElogV
import heapq
import sys

input = sys.stdin.readline


def prim(graph, start):
    visited = set([start])
    edges = [(cost, start, end) for end, cost in graph[start]]
    heapq.heapify(edges)

    result = 0
    while edges:
        w, s, e = heapq.heappop(edges)
        if e not in visited:
            visited.add(e)
            result += w
            for ne, nw in graph[e]:
                if ne not in visited:
                    heapq.heappush(edges, (nw, e, ne))

    print(result)


V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    s, e, w = map(int, input().split())
    graph[s].append((e, w))
    graph[e].append((s, w))

prim(graph, 1)
