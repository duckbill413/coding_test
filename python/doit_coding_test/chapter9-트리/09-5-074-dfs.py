# 11437 최소 공통 조상 구하기 1
import sys
sys.setrecursionlimit(10**8)

input = sys.stdin.readline
print = sys.stdout.write
N = int(input())
graph = [[] for _ in range(N + 1)]

for i in range(N - 1):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

# dfs 방식
depth = [0] * (N + 1)
parent = [0] * (N + 1)
visited = set()


def dfs(node, level):
    for next in graph[node]:
        if next not in visited:
            visited.add(next)
            parent[next] = node
            depth[next] = level
            dfs(next, level + 1)


visited.add(1)
dfs(1, 1)


def executeLCA(a, b):
    # a의 dept가 더 크거나 같게 순서 변경
    if depth[a] < depth[b]:
        a, b = b, a

    # depth 맞추기
    while depth[a] != depth[b]:
        a = parent[a]

    # 공통 조상 찾기
    while a != b:
        a = parent[a]
        b = parent[b]

    return a


M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    print(str(executeLCA(a, b)) + '\n')
