N, M = map(int, input().split())
A, B, d = map(int, input().split())

move = {0: (-1, 0), 1: (0, -1), 2: (1, 0), 3: (0, 1)}

visited = [[False] * M for i in range(N)]
board = []
for row in range(N):
    tmp = list(map(int, input().split()))
    board.append(tmp)

trying = 0
count = 0
while True:
    if trying == 4:
        back = (d+2) % 4
        A += move[back][0]
        B += move[back][1]
        if board[A][B] == 1:
            break
        trying = 0
        continue

    d = (d + 1) % 4
    nx = A + move[d][0]
    ny = B + move[d][1]
    trying += 1

    if visited[nx][ny] or board[nx][ny] == 1:
        continue
    A, B = nx, ny
    visited[A][B] = True
    count += 1
    trying = 0

print(count)