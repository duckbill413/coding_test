# 1043 거짓말쟁이가 되긴 싫어

N, M = map(int, input().split())
truth = list(map(int, input().split()))[1:]
parties = []
for i in range(M):
    parties.append(list(map(int, input().split())))

parent = [i for i in range(N + 1)]


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


for i in range(M):
    size = parties[i][0]
    first_people = parties[i][1]
    for j in range(2, size+1):
        union_parent(parent, first_people, parties[i][j])

count = 0
for i in range(M):
    flag = False
    first_people = parties[i][1]
    for j in range(len(truth)):
        if find_parent(parent, first_people) == find_parent(parent, truth[j]):
            flag = True
            break

    if not flag:
        count += 1

print(count)
