# 11724 연결 요소의 개수 구하기
# 깊이 우선 탐색 (DFS)
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for i in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

visited = [False] * (N + 1)

def dfs(start, graph, visited):
    visited[start] = True

    for next in graph[start]:
        if not visited[next]:
            dfs(next, graph, visited)


answer = 0
for i in range(1, N+1):
    if not visited[i]:
        answer += 1
        dfs(i, graph, visited)

print(answer)
