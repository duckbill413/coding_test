# 28256 초콜릿 보관함

import sys

input = sys.stdin.readline

T = int(input())

dr = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def inRange(x, y):
    return 0 <= x < 3 and 0 <= y < 3


def dfs(start):
    count = 1

    for i in range(4):
        nx = start[0] + dr[i][0]
        ny = start[1] + dr[i][1]

        if not inRange(nx, ny):
            continue

        if (nx, ny) not in visited and A[nx][ny] == 'O':
            visited.append((nx, ny))
            count += dfs((nx, ny))
    return count


for test_case in range(1, T + 1):
    A = [list(input().strip()) for _ in range(3)]
    B = list(map(int, input().split()))
    visited = []
    answer = []
    for i in range(3):
        for j in range(3):
            if (i, j) not in visited and A[i][j] == 'O':
                visited.append((i, j))
                answer.append(dfs((i, j)))

    print(1) if B[1:] == sorted(answer) else print(0)