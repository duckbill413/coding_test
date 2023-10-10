import collections

move = [
    (-1, 0),
    (1, 0),
    (0, -1),
    (0, 1)
]


def in_range(x, y):
    global N, M
    return 0 <= x < N and 0 <= y < M


def bfs(maps):
    q = collections.deque()
    q.append((0, 0))
    visited = [[-1 for j in range(M)] for i in range(N)]
    visited[0][0] = 1

    while q:
        x, y = q.popleft()

        if (x, y) == (N - 1, M - 1):
            return visited[x][y]

        for i in range(4):
            nx = x + move[i][0]
            ny = y + move[i][1]

            if in_range(nx, ny) and visited[nx][ny] == -1 and maps[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))

    return -1


def solution(maps):
    global N, M
    N = len(maps)
    M = len(maps[0])

    return bfs(maps)
