# 2194 유닛 이동시키기
import collections
import sys

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M, A, B, K = map(int, input().split())

board = [[False for j in range(M + 1)] for i in range(N + 1)]
for _ in range(K):
    a, b = map(int, input().split())
    board[a][b] = True

sx, sy = map(int, input().split())
ex, ey = map(int, input().split())


def canMove(x, y):
    if x < 1 or y < 1 or x + A - 1 > N or y + B - 1 > M:
        return False
    for i in range(x, x + A):
        for j in range(y, y + B):
            if board[i][j]:
                return False
    return True


visited = [[False for j in range(M + 1)] for i in range(N + 1)]

q = collections.deque()
q.append((sx, sy, 0))
visited[sx][sy] = True

while q:
    cur = q.popleft()

    if (cur[0], cur[1]) == (ex, ey):
        print(cur[2])
        exit()

    for i in range(4):
        nx = cur[0] + dx[i]
        ny = cur[1] + dy[i]

        if canMove(nx, ny) and not visited[nx][ny]:
            visited[nx][ny] = True
            q.append((nx, ny, cur[2] + 1))

print(-1)