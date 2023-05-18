# 장애물 인식 프로그램
import sys

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(start, obstacles):
    visited[start[0]][start[1]] = True

    for i in range(4):
        nx = start[0] + dx[i]
        ny = start[1] + dy[i]

        if 0 <= nx < N and 0 <= ny < N and table[nx][ny] == 1 and not visited[nx][ny]:
            obstacles.append((nx, ny))
            dfs((nx, ny), obstacles)


def solve():
    answer = []
    for i in range(N):
        for j in range(N):
            if table[i][j] == 1 and not visited[i][j]:
                obstacles = [(i, j)]
                dfs((i, j), obstacles)
                answer.append(len(obstacles))
    answer.sort()
    print(len(answer))
    print(*answer, sep='\n')


if __name__ == '__main__':
    N = int(input())
    table = [list(map(int, input().rstrip())) for _ in range(N)]
    visited = [[False for j in range(N)] for i in range(N)]
    solve()
