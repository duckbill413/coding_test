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
        parent[a] = b


def solution(n, computers):
    parent = [i for i in range(n)]

    for i in range(n):
        for j in range(n):
            if i == j: continue
            if computers[i][j] == 1 and find_parent(parent, i) != find_parent(parent, j):
                union_parent(parent, i, j)

    network = set()
    for i in range(n):
        if find_parent(parent, i) not in network:
            network.add(find_parent(parent, i))
    return len(network)
