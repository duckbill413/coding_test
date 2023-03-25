# 2252 줄 세우기
import collections
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

indegree = [0] * (N + 1)
graph= [[] for i in  range(N+1)]

for i in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    indegree[b] += 1

def topology_sort():
    result = []
    q = collections.deque()

    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        result.append(now)

        for next in graph[now]:
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    print(*result, sep=' ')

topology_sort()