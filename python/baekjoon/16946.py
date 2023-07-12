import sys
import collections

input = sys.stdin.readline

N, M = map(int, input().split())
A = []
for i in range(N):
    A.append(list(map(int, input().strip())))
count = [[None for j in range(M)] for i in range(N)]
visited = [[False for j in range(M)] for i in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

group_code = 0


def bfs(start):
    path = collections.deque([start])
    q = collections.deque([start])
    visited[start[0]][start[1]] = True
    answer = 0

    while q:
        x, y = q.popleft()
        answer += 1

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue

            if not visited[nx][ny] and A[nx][ny] == 0:
                visited[nx][ny] = True
                q.append((nx, ny))
                path.append((nx, ny))

    while path:
        x, y = path.popleft()
        count[x][y] = (group_code, answer)


for i in range(N):
    for j in range(M):
        if A[i][j] == 0 and not visited[i][j]:
            bfs((i, j))
            group_code += 1


def counting(start):
    result = 1
    group = []

    for i in range(4):
        nx = start[0] + dx[i]
        ny = start[1] + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue

        if A[nx][ny] == 0:
            code, c = count[nx][ny]
            if code not in group:
                group.append(code)
                result += c
    return result


answer = [[0 for i in range(M)] for j in range(N)]
for i in range(N):
    for j in range(M):
        if A[i][j] == 1:
            answer[i][j] = counting((i, j)) % 10

for i in range(N):
    print(*answer[i], sep='')
