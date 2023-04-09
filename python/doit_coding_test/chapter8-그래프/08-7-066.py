# 1414 불우이웃돕기

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


def convert_alpha_to_cost(alpha):
    if alpha == '0':
        return 0
    if ord(alpha) >= ord('a'):
        return ord(alpha) - ord('a') + 1
    else:
        return ord(alpha) - ord('A') + 27


N = int(input())
computers = []
for _ in range(N):
    computers.append(list(input()))

edges = []
q   
total = 0
for i in range(N):
    for j in range(N):
        length = convert_alpha_to_cost(computers[i][j])
        total += length
        if i != j and length != 0:
            edges.append((length, i + 1, j + 1))

edges.sort()

parent = [i for i in range(N + 1)]

result = 0
useEdge = 0
for edge in edges:
    w, u, v = edge
    if find_parent(parent, u) != find_parent(parent, v):
        union_parent(parent, u, v)
        result += w
        useEdge += 1

if useEdge == N - 1:
    print(total - result)
else:
    print(-1)
