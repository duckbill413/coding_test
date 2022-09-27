# 음료수 얼려 먹기
N, M = map(int, input().split())
graph = []
for i in range(N):
    graph.append(list(map(int, input())))


def dfs(x, y):
    if x < 0 or y < 0 or x >= N or y >= M:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x-1, y)
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

# 모든 노드에 대하여 음료수 채우기
count = 0
for i in range(N):
    for j in range(M):
        if dfs(i, j):
            count += 1

print(count)