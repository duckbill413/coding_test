# 2. 팀 결성
'''
1. '팀 합치기' 연산은 두 팀을 합치는 연산이다.
2. '같은 팀 여부 확인'연산은 특정한 두 학생이 같은 팀에 속하는지를 확인하는 연산이다.
'''

N, M = map(int, input().split())
parent = [i for i in range(N+1)]

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


for i in range(M):
    s, a, b = map(int, input().split())
    if s == 1:
        if find_parent(parent, a) == find_parent(parent, b):
            print("YES")
        else:
            print("NO")
    elif s == 0:
        union_parent(parent, a, b)


'''
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
'''