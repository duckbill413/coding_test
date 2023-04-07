# 1197 최소 신장 트리 구하기 (MST)
# 크루스칼
import sys
import heapq

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
q = []

for i in range(E):
    s, e, w = map(int, input().split())
    heapq.heappush(q, (w, s, e))

useEdge = 0
result = 0

while useEdge < V - 1:  # MST는 항상 N-1의 에지를 사용함
    w, s, e = heapq.heappop(q)
    if find_parent(parent, s) != find_parent(parent, e):
        union_parent(parent, s, e)
        result += w
        useEdge += 1

print(result)
