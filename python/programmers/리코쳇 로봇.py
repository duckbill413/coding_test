import collections

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def in_range(x, y):
    global N, M
    return 0 <= x < N and 0 <= y < M


def move(x, y, d):
    global B
    while True:
        nx = x + dx[d]
        ny = y + dy[d]
        if in_range(nx, ny) and B[nx][ny] != 'D':
            x, y = nx, ny
        else:
            return x, y


def bfs(S, E):
    global N, M
    q = collections.deque([(S[0], S[1], 0)])
    visited = [[False for j in range(M)] for i in range(N)]
    visited[S[0]][S[1]] = True

    while q:
        x, y, c = q.popleft()

        if (x, y) == E:
            return c

        for d in range(4):
            nx, ny = move(x, y, d)

            if not visited[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, c + 1))
    return -1


def solution(board):
    global N, M, B
    N, M = len(board), len(board[0])
    B = board

    for i in range(N):
        for j in range(M):
            if B[i][j] == 'R':
                S = (i, j)
            elif B[i][j] == 'G':
                E = (i, j)

    return bfs(S, E)
