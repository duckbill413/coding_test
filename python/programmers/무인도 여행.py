import collections

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def in_range(x, y):
    global N, M
    return 0 <= x < N and 0 <= y < M

def bfs(start):
    global visited, Maps
    q = collections.deque([start])
    visited[start[0]][start[1]] = True

    count = 0
    while q:
        x, y = q.popleft()
        count += int(Maps[x][y])

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if in_range(nx, ny) and not visited[nx][ny] and '1' <= Maps[nx][ny] <= '9':
                visited[nx][ny] = True
                q.append((nx, ny))
    return count

def solution(maps):
    global visited, Maps, N, M
    N, M = len(maps), len(maps[0])
    Maps = [list(maps[i]) for i in range(N)]
    visited = [[False for j in range(M)] for i in range(N)]
    answer = []

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and maps[i][j] != 'X':
                answer.append(bfs((i, j)))

    return sorted(answer) if len(answer) > 0 else [-1]