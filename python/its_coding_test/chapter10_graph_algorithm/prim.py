# 프림 알고리즘 - 신장 트리
import collections
import heapq
import sys

sys.setrecursionlimit(10 ** 6)  # 재귀 깊이 조절
input = sys.stdin.readline

v, e = map(int, input().split())
visited = [False] * (v + 1)
edges = collections.defaultdict(list)

for i in range(e):
    a, b, cost = map(int, input().split())
    edges[a].append([cost, a, b])
    edges[b].append([cost, b, a])


def prim(start):
    visited[start] = True  # 방문 갱신
    candidate = edges[start]  # 인접 간선 추출
    heapq.heapify(candidate)  # 우선 순위 큐 생성
    mst = []
    total_weight = 0  # 전체 가중치

    while candidate:
        cost, a, b = heapq.heappop(candidate)

        if not visited[b]:
            visited[b] = True
            mst.append((a, b))
            total_weight += cost

            for edge in edges[b]:
                if not visited[edge[2]]:
                    heapq.heappush(candidate, edge)

    return total_weight


print(prim(1))
