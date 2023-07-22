# 7511 소셜 네트워킹 어플리케이션
import sys

input = sys.stdin.readline
print = sys.stdout.write

T = int(input())


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


for test_case in range(1, T + 1):
    N = int(input())
    graph = [[] for i in range(N)]
    parent = [i for i in range(N)]

    K = int(input())
    for k in range(K):
        a, b = map(int, input().split())
        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)

    print(f'Scenario {test_case}:\n')
    M = int(input())
    for m in range(M):
        a, b = map(int, input().split())
        if find_parent(parent, a) == find_parent(parent, b):
            print(str(1) + '\n')
        else:
            print(str(0) + '\n')
    print('\n')