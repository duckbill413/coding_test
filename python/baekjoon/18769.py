# 18769 그리드 네트워크

import sys

input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] == x:
        return x
    parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a != b:
        parent[a] = b


T = int(input())

for test_case in range(T):
    R, C = map(int, input().split())
    parent = [i for i in range(R * C)]

    edges = []
    for i in range(R):
        path = list(map(int, input().split()))
        for j in range(len(path)):
            edges.append((path[j], i, j, i, j + 1))

    for i in range(R - 1):
        path = list(map(int, input().split()))
        for j in range(len(path)):
            edges.append((path[j], i, j, i + 1, j))

    edges.sort()

    answer = 0
    for edge in edges:
        w, sx, sy, ex, ey = edge
        if find_parent(parent, sx * C + sy) != find_parent(parent, ex * C + ey):
            union_parent(parent, sx * C + sy, ex * C + ey)
            answer += w
    print(answer)
