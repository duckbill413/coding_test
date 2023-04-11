# 11725 트리의 부모 찾기
import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

N = int(input())

graph = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)
parent = [0] * (N + 1)

def dfs(start):
    visited[start] = True
    for next in graph[start]:
        if not visited[next]:
            parent[next] = start
            dfs(next)

dfs(1)

print(*parent[2:], sep='\n')