# 다익스트라 ( 우선순위 큐 O(ElogV) V: 노드 개수, E: 간선 개수)
import heapq
import sys

input = sys.stdin.readline
INF = int(1e9)

n, m = map(int, input().split())
start = int(input())

graph = [[] for i in range(n + 1)]
dist = [INF] * (n + 1)

# 모든 간선 정보 입력
for i in range(m):
    s, e, c = map(int, input().split())
    graph[s].append((e, c))


def dijkstra(start):
    q = []
    # 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        cost, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적 있는 노드라면 무시
        if dist[now] < cost:
            continue
        # 현재 노드와 인접 노드를 확인
        for next in graph[now]:
            c = cost + next[1]
            # 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            if c < dist[next[0]]:
                dist[next[0]] = c
                heapq.heappush(q, (c, next[0]))


dijkstra(start)

for i in range(1, n + 1):
    if dist[i] == INF:
        print("INFINITY")
    else:
        print(dist[i])

'''
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
'''
