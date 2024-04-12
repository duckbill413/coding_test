# 꼬리잡기놀이
import collections
import sys

input = sys.stdin.readline
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

N, M, K = map(int, input().split())
blocks = [list(map(int, input().split())) for _ in range(N)]

teams = collections.defaultdict(list)


def in_range(x, y):
    return 0 <= x < N and 0 <= y < N


def dfs(start):
    teams[team_id].append([start[0], start[1], blocks[start[0]][start[1]]])
    visited[start[0]][start[1]] = True
    for i in range(4):
        nx = start[0] + dx[i]
        ny = start[1] + dy[i]
        if in_range(nx, ny) and blocks[nx][ny] != 0 and not visited[nx][ny]:
            if len(teams[team_id]) == 1 and blocks[nx][ny] == 2:
                dfs((nx, ny))
            elif len(teams[team_id]) == 1:
                continue
            dfs((nx, ny))
            break


visited = [[False for j in range(N)] for i in range(N)]

team_id = 0
for i in range(N):
    for j in range(N):
        if blocks[i][j] == 1 and not visited[i][j]:
            dfs((i, j))
            team_id += 1

for team in teams:
    print(teams[team])
