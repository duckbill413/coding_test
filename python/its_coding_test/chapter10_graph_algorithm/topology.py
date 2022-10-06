# 위상 정렬
# 방향 그래프의 모든 노드를 '방향성에 거스르지 않도록 순서대로 정렬
# 대학의 선수 과목 이수를 생각하면 됨
'''
1. 진입차수가 0인 노드를 큐에 넣는다
2. 큐가 빌 때까지 다음의 과정을 반복한다.
    1) 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다.
    2) 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.

일반적으로 사이클은 고려하지 않는다.
시간복잡도: O(V+E)
'''
from collections import deque

v, e = map(int, input().split())
indegree = [0] * (v + 1)
# 각 노드에 연결된 간선 정보를 담기 위한 연결 리스트 초기화
graph = [[] for i in range(v + 1)]

# 방향 그래프의 모든 간선 정보를 입력
for i in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    # 진입차수를 1 증가
    indegree[b] += 1


# 위상 정렬 함수
def topology_sort():
    result = []  # 알고리즘 수행 결과를 담을 리스트
    q = deque()

    # 처음 시작할 때는 진입차수가 0인 노드 큐에 삽입
    for i in range(1, v + 1):
        if indegree[i] == 0:
            q.append(i)

    # 큐가 빌 때까지 반복
    while q:
        now = q.popleft()
        result.append(now)
        for next in graph[now]:
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    # 위상 정렬을 수행한 결과 출력
    for r in result:
        print(r, end=' ')


topology_sort()

'''
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
'''