# 22. 블록 이동하기
import collections


def get_next(now, board):
    next_pos = []
    now = list(now)

    x1, y1, x2, y2 = now[0][0], now[0][1], now[1][0], now[1][1]
    # 상하좌우 이동
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nx1, ny1, nx2, ny2 = x1 + dx[i], y1 + dy[i], x2 + dx[i], y2 + dy[i]
        if board[nx1][ny1] == 0 and board[nx2][ny2] == 0:
            next_pos.append({(nx1, ny1), (nx2, ny2)})
    # 위, 아래로 회전
    if x1 == x2:
        for i in [-1, 1]:
            if board[x1 + i][y1] == 0 and board[x2 + i][y2] == 0:
                next_pos.append({(x1, y1), (x1 + i, y1)})
                next_pos.append({(x2, y2), (x2 + i, y2)})
    # 좌, 우 회전
    if y1 == y2:
        for i in [-1, 1]:
            if board[x1][y1 + i] == 0 and board[x2][y2 + i] == 0:
                next_pos.append({(x1, y1), (x1, y1 + i)})
                next_pos.append({(x2, y2), (x2, y2 + i)})
    return next_pos


def solution(board):
    length = len(board)
    new_board = [[1] * (length + 2) for _ in range(length + 2)]
    for i in range(length):
        for j in range(length):
            new_board[i + 1][j + 1] = board[i][j]

    q = collections.deque()
    visited = []

    start = {(1, 1), (1, 2)}
    q.append((start, 0))
    visited.append(start)

    while q:
        now, cost = q.popleft()

        if (length, length) in now:
            return cost

        for next_pos in get_next(now, new_board):
            if next_pos not in visited:
                q.append((next_pos, cost + 1))
                visited.append(next_pos)
    return 0


board = [[0, 0, 0, 1, 1],
         [0, 0, 0, 1, 0],
         [0, 1, 0, 1, 1],
         [1, 1, 0, 0, 1],
         [0, 0, 0, 0, 0]]

print(solution(board))
