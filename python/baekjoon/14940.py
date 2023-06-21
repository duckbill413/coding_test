# 14940 쉬운 최단거리
import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = []
for i in range(N):
    A.append(list(map(int, input().split())))

visited = [[0] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(start):
    q = collections.deque()
    q.append(start)

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if visited[nx][ny] != 0:
                continue
            if A[nx][ny] == 1:
                visited[nx][ny] = visited[x][y] + 1
                q.append((nx, ny))


for i in range(N):
    for j in range(M):
        if A[i][j] == 2:
            bfs((i, j))
            for x in range(N):
                for y in range(M):
                    if A[x][y] == 1 and visited[x][y] == 0:
                        visited[x][y] = -1
            for k in range(N):
                print(*visited[k], sep=' ')