# 1707 이분 그래프 판별하기
# 이분 그래프는 사이클이 형성 되지 않을때 가능하다.
K = int(input())


def dfs(v):
    global isEven
    visited[v] = True

    for next in A[v]:
        if not visited[next]:
            # 인접 노드는 같은 집합이 아니므로 다른 집합으로 처리
            check[next] = (check[v] + 1) % 2
            dfs(next)
        elif check[next] == check[v]:
            isEven = False

for i in range(K):
    V, E = map(int, input().split())

    A = [[] for _ in range(V + 1)]
    for i in range(E):
        s, e = map(int, input().split())
        A[s].append(e)
        A[e].append(s)

    visited = [False] * (V + 1)
    check = [0] * (V + 1)
    isEven = True

    for i in range(1, V + 1):
        if isEven:
            dfs(i)
        else:
            break

    print("YES") if isEven else print("NO")
