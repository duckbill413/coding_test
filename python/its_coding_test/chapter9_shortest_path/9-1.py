# 다익스트라 알고리즘 (순차탐색 O(N^2))
'''
음의 간선이 없을때 작동 한다.

1. 출발 노드를 설정
2. 최단 거리 테이블을 초기화
3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택
4. 해당 노드를 거쳐 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신
5. 3, 4번 과정을 반복
'''

import sys
input = sys.stdin.readline
INF = int(1e9)

# 노드의 개수, 간선의 개수 입력
n, m = map(int, input().split())
# 시작 노드의 번호
start = int(input())
# 각 노드에 연결된 정보를 담은 리스트
graph = [[] for _ in range(n+1)]
# 방문한 적이 있는지 체크하는 목적의 리스트
visited = [False] * (n+1)
# 최단 거리 테이블을 무한으로 초기화
dist = [INF] * (n+1)

# 모든 간선의 정보 입력 받기
for i in range(m):
    # s: 시작 e: 종료 c: 비용
    s, e, c = map(int, input().split())
    graph[s].append((e, c))


# 방문하지 않은 노드 중에서, 가장 최단 거리가 짧은 노드의 번호를 반환
def get_smallest_node():
    min_value = INF
    index = 0 # 가장 최단거리가 짧은 노드의 인덱스
    for i in range(1, n+1):
        if dist[i] < min_value and not visited[i]:
            min_value = dist[i]
            index = i
    return index


def dijkstra(start):
    # 시작 노드에 대하여 초기화
    dist[start] = 0
    visited[start] = True
    for g in graph[start]:
        dist[g[0]] = g[1]

    # 시작 노드를 제외한 전체 노드에 대하여 반복
    for i in range(n-1):
        # 현재 최단 거리가 가장 짧은 노드를 꺼내서, 방문처리
        now = get_smallest_node()
        visited[now] = True
        for j in graph[now]:
            cost = dist[now] + j[1]
            if cost < dist[j[0]]:
                dist[j[0]] = cost

dijkstra(start)

# 모든 노드로 가기 위한 최단 거리 출력
for i in range(1, n+1):
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