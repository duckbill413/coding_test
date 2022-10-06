# 3. 도시 분할 계획
'''
두개의 최소 신장 트리를 만들어야 한다.
크루스칼 알고리즘으로 최소 신장 트리를 찾은 뒤에 최소 신장 트리를 구성하는 간선 중에서 가장 비용이 큰 간선을 제거 하면 된다.
'''
import sys

input = sys.stdin.readline


def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


N, M = map(int, input().split())
parent = [i for i in range(N+1)]
edges = []

for i in range(M):
    A, B, C = map(int, input().split())
    edges.append((C, A, B))

edges.sort() # 비용을 기준으로 오름차순 정렬

result = 0
big_node = 0
for edge in edges:
    cost, a, b = edge
    if find_parent(parent, a) == find_parent(parent, b):
        continue

    union_parent(parent, a, b)
    result += cost
    if cost > big_node:
        big_node = cost

print(result - big_node)


'''
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
'''