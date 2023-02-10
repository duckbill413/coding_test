# 13023 친구 관계 파악하기
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

edges = [[] for _ in range(N)]
for i in range(M):
    a, b = map(int, input().split())
    edges[a].append(b)
    edges[b].append(a)

visited = [False] * N
arrive = False


def dfs(now, depth, visited, edges):
    global arrive
    if depth == 5:
        arrive = True
        return

    visited[now] = True
    for next in edges[now]:
        if not visited[next]:
            dfs(next, depth + 1, visited, edges)
    visited[now] = False


for i in range(N):
    dfs(i, 1, visited, edges)
    if arrive:
        print(1)
        break

if not arrive:
    print(0)