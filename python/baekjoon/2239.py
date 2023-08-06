# 2239 스도쿠
import collections
import sys

sys.setrecursionlimit(10 ** 8)
input = sys.stdin.readline

SIZE = 9

sudocu = [list(map(int, input().strip())) for _ in range(SIZE)]
house = [[[False for i in range(SIZE + 1)] for j in range(SIZE + 1)] for k in range(3)]
zeros = []
for i in range(SIZE):
    for j in range(SIZE):
        if sudocu[i][j] == 0:
            zeros.append((i, j))
            continue
        num = sudocu[i][j]
        house[0][i][num] = True
        house[1][j][num] = True
        house[2][i // 3 * 3 + j // 3][num] = True


def dfs(depth):
    if depth == len(zeros):
        for i in range(SIZE):
            print(*sudocu[i], sep='')
        exit()

    x, y = zeros[depth]

    for n in range(1, 10):
        if not house[0][x][n] and not house[1][y][n] and not house[2][x // 3 * 3 + y // 3][n]:
            sudocu[x][y] = n
            house[0][x][n] = True
            house[1][y][n] = True
            house[2][x // 3 * 3 + y // 3][n] = True

            dfs(depth + 1)

            sudocu[x][y] = 0
            house[0][x][n] = False
            house[1][y][n] = False
            house[2][x // 3 * 3 + y // 3][n] = False


dfs(0)
