# 13460 구슬 탈출 2
import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
board = [list(input().strip()) for _ in range(N)]

# 빨간공, 파란공 위치 탐색
for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            rx, ry = i, j
        elif board[i][j] == 'B':
            bx, by = i, j

dr = [(-1, 0), (1, 0), (0, -1), (0, 1)]

# BFS 방식을 이용하여 탐색
q = collections.deque()
q.append((rx, ry, bx, by, 0))
visited = [(rx, ry, bx, by)]
answer = int(1e9)

while q:
    rx, ry, bx, by, count = q.popleft()

    if count > 10:
        break

    if board[rx][ry] == 'O':
        answer = count
        break

    for i in range(4):
        nrx, nry = rx, ry
        r_move = 0
        while True:
            nrx += dr[i][0]
            nry += dr[i][1]
            r_move += 1
            if board[nrx][nry] == '#':
                nrx -= dr[i][0]
                nry -= dr[i][1]
                r_move -= 1
                break
            if board[nrx][nry] == 'O':
                break

        nbx, nby = bx, by
        b_move = 0
        while True:
            nbx += dr[i][0]
            nby += dr[i][1]
            b_move += 1
            if board[nbx][nby] == '#':
                nbx -= dr[i][0]
                nby -= dr[i][1]
                b_move -= 1
                break
            if board[nbx][nby] == 'O':
                break
        # 파란색이 구멍에 들어가서는 안됨
        if board[nbx][nby] == 'O':
            continue

        # 빨간공과 파란공의 위치가 같을 경우 이동거리 비교
        if nrx == nbx and nry == nby:
            if r_move < b_move:
                nbx -= dr[i][0]
                nby -= dr[i][1]
            else:
                nrx -= dr[i][0]
                nry -= dr[i][1]
        if (nrx, nry, nbx, nby) not in visited:
            q.append((nrx, nry, nbx, nby, count+1))
            visited.append((nrx, nry, nbx, nby))

print(answer) if answer != int(1e9) else print(-1)