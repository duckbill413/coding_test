# topology sort
# 위상 정렬은 사이클이 없는 방향 그래프에서 노드 순서를 찾는 알고리즘
# 기능                 특징                     시간 복잡도(노드 수: V, 에지 수: E)
# 노드 간의 순서를 결정  사이클이 없어야 함         O(V + E)
import collections

v, e = map(int, input().split())
indegree = [0] * (v + 1)  # 진입 차수
graph = [[] for i in range(v + 1)]  # 인접 행렬

for i in range(e):
    s, e = map(int, input().split())
    graph[s].append(e)
    indegree[e] += 1


def topology_sort():
    result = []  # 알고리즘 수행 결과 리스트
    q = collections.deque()

    # 처음 시작하는 진입 차수가 0인 노드를 큐에 삽입
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

    print(*result, sep=' ')

topology_sort()