# 유니온 파인드
'''
find
find 연산을 수행할 때 재귀 함수에서 나오면서 탐색한 모든 노드의 대표 노드값을
이번 연산에서 발견한 대표 노드 값으로 변경해야 한다.
union
union 연산에서 선택된 노드끼리 연결하는 것이 아닌 선택한 노드의 대표 노드 끼리 연결해야 한다.
'''
def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a > b:
        parent[a] = b
    else:
        parent[b] = a