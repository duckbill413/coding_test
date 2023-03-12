# 1976 여행 계획 짜기
import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N = int(input())
M = int(input())
parent = [i for i in range(N + 1)]


def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]
    return x


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a != b:
        parent[a] = b


for i in range(1, N + 1):
    roots = list(map(int, input().split()))
    for j in range(1, N + 1):
        if roots[j-1] == 1:
            union_parent(parent, i, j)


travel = list(map(int, input().split()))
pivot = find_parent(parent, travel[0])
flag = True
for i in range(M):
    if pivot != find_parent(parent, travel[i]):
        flag = False
        break

print('YES') if flag else print('NO')