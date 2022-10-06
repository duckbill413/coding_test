# 서로소 집합(Disjoint Sets) - 사이클 판별

# 특정 원소의 부모 노드 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x


# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)  # a's parent
    b = find_parent(parent, b)  # b's parent

    # 부모 갱신
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 노드의 개수와 간선(union 연산)의 개수 입력 받기
v, e = map(int, input().split())
parent = [i for i in range(v + 1)]

cycle = False  # 사이클 발생 여부
# union 연산의 수행
for i in range(e):
    a, b = map(int, input().split())
    if find_parent(parent, a) == find_parent(parent, b):
        cycle = True
        break
    else:
        union_parent(parent, a, b)

print(cycle)

'''
3 3
1 2
1 3
2 3
'''
