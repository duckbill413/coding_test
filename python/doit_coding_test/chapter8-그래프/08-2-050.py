# 1717 집합 표현하기
import sys

input = sys.stdin.readline
sys.setrecursionlimit(100000)

N, M = map(int, input().split())
parent = [i for i in range(N + 1)]


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]
    return x


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    parent[a] = b


for i in range(M):
    S, A, B = map(int, input().split())
    if S == 0:
        union_parent(parent, A, B)
    elif S == 1:
        if find_parent(parent, A) == find_parent(parent, B):
            print('YES')
        else:
            print('NO')
