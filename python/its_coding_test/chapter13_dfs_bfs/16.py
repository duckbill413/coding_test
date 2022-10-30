# 16. 연구소
import collections

n, m = map(int, input().split())
board = []
for i in range(n):
    board.append(list(map(int, input().split())))
temp = [[0] * m for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def virus(start):
    q = collections.deque()
    q.append(start)

    while q:
        cur = q.popleft()

        for i in range(4):
            nx = cur[0] + dx[i]
            ny = cur[1] + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= m:
                continue

            if temp[nx][ny] == 0:
                q.append((nx, ny))
                temp[nx][ny] = 2


def get_score():
    count = 0
    for i in range(n):
        for j in range(m):
            if temp[i][j] == 0:
                count += 1
    return count

result = 0
def dfs(count):
    global result
    if count == 3:
        for i in range(n):
            for j in range(m):
                temp[i][j] = board[i][j]
        for i in range(n):
            for j in range(m):
                if temp[i][j] == 2:
                    virus((i, j))
        result = max(result, get_score())
        return

    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                board[i][j] = 1
                dfs(count + 1)
                board[i][j] = 0

dfs(0)
print(result)