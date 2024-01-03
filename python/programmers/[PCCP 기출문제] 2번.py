import collections

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def in_range(x, y):
    global N, M
    return 0 <= x < N and 0 <= y < M


def bfs(start):
    global N, M, visited, oils
    visited_column = set()
    q = collections.deque([start])
    visited[start[0]][start[1]] = True

    cost = 0
    while q:
        cur = q.popleft()
        cost += 1

        if cur[1] not in visited_column:
            visited_column.add(cur[1])

        for i in range(4):
            nx = cur[0] + dx[i]
            ny = cur[1] + dy[i]

            if in_range(nx, ny) and not visited[nx][ny] and g_land[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx, ny))

    for column in visited_column:
        oils[column] += cost


def solution(land):
    global N, M, visited, oils, g_land
    g_land = land
    N, M = len(land), len(land[0])
    oils = [0] * M
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and land[i][j] == 1:
                bfs((i, j))
                # print(oils)

    return max(oils)
