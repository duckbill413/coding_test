import collections

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def in_range(x, y):
    global N, M
    return 0 <= x < N and 0 <= y < M

def bfs(start, find):
    global N, M, Map
    visited = [[-1 for j in range(M)] for i in range(N)]
    q = collections.deque()
    visited[start[0]][start[1]] = 0
    q.append(start)

    while q:
        x, y = q.popleft()

        if Map[x][y] == find:
            return visited[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if in_range(nx, ny) and Map[nx][ny] != 'X':
                if visited[nx][ny] == -1:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx, ny))

    return -1

def solution(maps):
    global N, M, Map
    N, M = len(maps), len(maps[0])
    Map = [list(maps[i]) for i in range(N)]

    for i in range(N):
        for j in range(M):
            if Map[i][j] == 'S':
                S = (i, j)
            elif Map[i][j] == 'L':
                L = (i, j)

    result1 = bfs(S, 'L')
    # print(result1)
    if result1 == -1: return -1

    result2 = bfs(L, 'E')
    # print(result2)
    if result2 == -1: return -1

    return result1 + result2