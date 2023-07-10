# 1799 비숍

import sys

input = sys.stdin.readline


def isBlack(x, y):
    return (x % 2 == 0 and y % 2 == 0) or (x % 2 == 1 and y % 2 == 1)


N = int(input())
board = [list(map(int, input().split())) for _ in range(N)]

right = [False] * (2 * N - 1)
left = [False] * (2 * N - 1)
black_count, white_count = 0, 0

black, white = [], []
for i in range(N):
    for j in range(N):
        if board[i][j] == 1 and isBlack(i, j):
            black.append((i, j))
        elif board[i][j] == 1 and not isBlack(i, j):
            white.append((i, j))


def solution(color, index, count):
    global black_count, white_count
    if index == len(color):
        x, y = color[index - 1]
        if isBlack(x, y):
            black_count = max(black_count, count)
        else:
            white_count = max(white_count, count)
        return

    x, y = color[index]
    if right[x + y] or left[x - y + N - 1]:
        solution(color, index + 1, count)
    else:
        right[x + y] = 1
        left[x - y + N - 1] = 1
        solution(color, index + 1, count + 1)
        right[x + y] = 0
        left[x - y + N - 1] = 0
        solution(color, index + 1, count)

if len(black) > 0:
    solution(black, 0, 0)
if len(white) > 0:
    solution(white, 0, 0)
print(black_count + white_count)