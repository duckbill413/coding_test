''' 다익스트라
그래프에서 최단 거리를 구하는 알고리즘
특정 노드에서 다른 노드들의 최단 거리를 구하는 문제에서 활용
1. 인접 리스트로 그래프 구현하기
2. 최단 거리 리스트 초기화하기
3. 값이 가장 작은 노드 고르기
4. 최단 거리 리스트 업데이트 하기
'''
import heapq
import sys
input = sys.stdin.readline

INF = int(1e9)

v, e = map(int, input().split())
start = int(input())

graph = [[] for i in range(v+1)]
result = [INF] * (v + 1)

for i in range(e):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    result[start] = 0

    while q:
        weight, now_node = heapq.heappop(q)

        if result[now_node] < weight:
            continue

        for next_node, next_weight in graph[now_node]:
            if weight + next_weight < result[next_node]:
                result[next_node] = weight + next_weight
                heapq.heappush(q, (weight + next_weight, next_node))

dijkstra(start)
print(result)