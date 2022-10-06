# 크루스칼 알고리즘 - 신장 트리 O(ElogE)
'''
1. 간선 데이터를 비용에 따라 오름차순으로 정렬
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생시키는지 확인
    1) 사이클이 발생하지 않는 경우 최소 신장 트리에 포함
    2) 사이클이 발생되는 경우 최소 신장 트리에 포함시키지 않는다.
3. 모든 간선에 대하여 2번의 과정을 반복
'''


# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x


# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 노드의 개수와 간선의 개수 입력
v, e = map(int, input().split())
parent = [i for i in range(v + 1)]
edges = []  # 모든 간선을 담을 리스트

for i in range(e):
    a, b, cost = map(int, input().split())
    edges.append((cost, a, b))

# 간선을 비용 순으로 정렬
edges.sort()

result = 0  # 모든 비용의 총합
for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우만 집합에 추가
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost

print(result)

'''
7 9
1 2 29
1 5 75
2 3 35
2 6 34
3 4 7
4 6 23
4 7 13
5 6 53
6 7 25
'''
