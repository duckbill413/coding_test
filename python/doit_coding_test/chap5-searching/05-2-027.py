# 2178 미로 탐색하기
import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
table = [list(map(int, input()[:-1])) for _ in range(N)]

visited = [[False] * M for _ in range(N)]
distance = [[0] * M for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(start):
    distance[start[0]][start[1]] = 1
    q = collections.deque([start])
    visited[start[0]][start[1]] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if not visited[nx][ny] and table[nx][ny] == 1:
                visited[nx][ny] = True
                distance[nx][ny] = distance[x][y] + 1
                q.append((nx, ny))


bfs((0, 0))
print(distance[N - 1][M - 1])
