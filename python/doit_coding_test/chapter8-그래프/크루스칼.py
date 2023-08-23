# 크루스칼
# 1197 최소 신장 트리 구하기
# ElogE
import sys

input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] == x:
        return x
    else:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a != b:
        parent[b] = a


V, E = map(int, input().split())
parent = [i for i in range(V + 1)]
edges = []

for i in range(E):
    s, e, w = map(int, input().split())
    edges.append((w, s, e))

edges.sort()

result = 0
for edge in edges:
    w, s, e = edge
    if find_parent(parent, s) != find_parent(parent, e):
        union_parent(parent, s, e)
        result += w

print(result)
