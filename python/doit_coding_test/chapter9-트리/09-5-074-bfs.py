# 11437 최소 공통 조상 구하기 1
import collections
import sys

input = sys.stdin.readline
print = sys.stdin.write

N = int(input())
graph = [[] for _ in range(N + 1)]

for i in range(N - 1):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)

# bfs 방식
depth = [0] * (N + 1)
parent = [0] * (N + 1)
visited = [False] * (N + 1)


def bfs(node):
    q = collections.deque()
    q.append(node)
    visited[node] = True

    level = 1
    now_size = 1
    count = 0
    while q:
        now_node = q.popleft()
        for next in graph[now_node]:
            if not visited[next]:
                visited[next] = True
                q.append(next)
                parent[next] = now_node  # 부모 노드 저장
                depth[next] = level  # 노드 depth 저장
        count += 1
        if count == now_size:
            count = 0
            now_size = len(q)
            level += 1


bfs(1)


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
