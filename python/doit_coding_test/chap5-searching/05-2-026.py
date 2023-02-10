# 1260 DFS와 BFS 프로그램
import collections
import sys

input = sys.stdin.readline

N, M, V = map(int, input().split())

edges = [[] for _ in range(N + 1)]
for i in range(M):
    s, e = map(int, input().split())
    edges[s].append(e)
    edges[e].append(s)


def dfs(now):
    global answer
    visited[now] = True
    answer.append(now)

    for next in edges[now]:
        if not visited[next]:
            dfs(next)


def bfs(start):
    global answer
    visited[start] = True
    q = collections.deque()
    q.append(start)

    while q:
        now = q.popleft()
        answer.append(now)

        for next in edges[now]:
            if not visited[next]:
                visited[next] = True
                q.append(next)


for i in range(N + 1):
    edges[i].sort()

visited = [False] * (N + 1)
answer = []
dfs(V)
print(*answer, sep=' ')

visited = [False] * (N + 1)
answer = []
bfs(V)
print(*answer, sep=' ')
