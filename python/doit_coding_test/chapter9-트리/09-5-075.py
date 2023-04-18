# 11438 최소 공통 조상 구하기2
import collections
import sys

sys.setrecursionlimit(10 ** 8)
input = sys.stdin.readline
print = sys.stdout.write

N = int(input())
tree = [[] for _ in range(N + 1)]

for _ in range(N - 1):
    s, e = map(int, input().split())
    tree[s].append(e)
    tree[e].append(s)

depth = [0] * (N + 1)
visited = set()

temp = 1
kmax = 0
while temp <= N:  # 최대 가능 depth 구하기
    temp <<= 1
    kmax += 1

parent = [[0 for i in range(N + 1)] for j in range(kmax + 1)]

def bfs(node):
    q = collections.deque()
    q.append(node)
    visited.add(node)

    level = 1
    node_size = 1
    count = 0
    while q:
        now_node = q.popleft()

        for next_node in tree[now_node]:
            if next_node not in visited:
                visited.add(next_node)
                q.append(next_node)
                parent[0][next_node] = now_node
                depth[next_node] = level
        count += 1
        if count == node_size:
            count = 0
            node_size = len(q)
            level += 1


bfs(1)

for k in range(1, kmax + 1):
    for n in range(1, N + 1):
        parent[k][n] = parent[k - 1][parent[k - 1][n]]


def executeLCA(a, b):
    # 더 깊은 depth 가 b가 되도록
    if depth[a] > depth[b]:
        a, b = b, a

    for k in range(kmax, -1, -1):  # depth 맞추기
        if pow(2, k) <= depth[b] - depth[a]:
            if depth[a] <= depth[parent[k][b]]:
                b = parent[k][b]

    for k in range(kmax, -1, -1):
        if a == b: break
        if parent[k][a] != parent[k][b]:
            a = parent[k][a]
            b = parent[k][b]

    LCA = a
    if a != b:
        LCA = parent[0][LCA]
    return LCA


M = int(input())
for _ in range(M):
    a, b = map(int, input().split())
    print(str(executeLCA(a, b)) + '\n')
