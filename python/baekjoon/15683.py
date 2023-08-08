# 15683 감시
import copy
import sys

input = sys.stdin.readline

dx = [0, -1, 1, 0, 0]
dy = [0, 0, 0, -1, 1]
cases = {1: [[1], [2], [3], [4]],
         2: [[1, 2], [3, 4]],
         3: [[1, 4], [4, 2], [2, 3], [3, 1]],
         4: [[1, 2, 3], [1, 2, 4], [2, 3, 4], [1, 3, 4]],
         5: [[1, 2, 3, 4]]
         }

N, M = map(int, input().split())
A = [list(map(int, input().strip().split())) for _ in range(N)]

cctv = []
for i in range(N):
    for j in range(M):
        if 0 < A[i][j] < 6:
            cctv.append((i, j, A[i][j]))


def in_range(x, y):
    return 0 <= x < N and 0 <= y < M


def search(x, y, d, visited):
    nx = x + dx[d]
    ny = y + dy[d]

    if in_range(nx, ny):
        if A[nx][ny] != 6:
            visited[nx][ny] = True
            search(nx, ny, d, visited)


def count_not_visited(visited):
    result = 0
    for i in range(N):
        for j in range(M):
            if A[i][j] == 0 and not visited[i][j]:
                result += 1
    return result


def dfs(depth, visited):
    global answer

    if depth == len(cctv):
        answer = min(answer, count_not_visited(visited))
        return

    for path in cases[cctv[depth][2]]:
        new_visited = copy.deepcopy(visited)
        for p in path:
            search(cctv[depth][0], cctv[depth][1], p, new_visited)
        dfs(depth + 1, new_visited)


visited = [[False for j in range(M)] for i in range(N)]
answer = int(1e9)
dfs(0, visited)
print(answer)
