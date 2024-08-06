import sys
import copy

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def is_movable(x, y, color, visited):
    global N, M, A
    return 0 <= x < N and 0 <= y < M and A[x][y] != 5 and not visited[color][x][y]

# color => 0: red, 1: blue
def dfs(red, blue, time, visited):
    global N, M, A, answer

    # 정답보다 더 큰 경우 중간에 중단
    if time >= answer:
        return
    # 둘다 오케이
    if A[red[0]][red[1]] == 3 and A[blue[0]][blue[1]] == 4:
        answer = min(answer, time)
        return

    # red, blue가 움직이는 방법은 총 16 가지
    for i in range(4): # i -> red
        rx, ry = red[0], red[1]
        if A[red[0]][red[1]] != 3:
            rx = red[0] + dx[i]
            ry = red[1] + dy[i]

            # 벽 또는 바깥
            if not is_movable(rx, ry, 0, visited):
                continue

        for j in range(4): # j -> blue
            bx, by = blue[0], blue[1]
            if A[blue[0]][blue[1]] != 4:
                bx = blue[0] + dx[j]
                by = blue[1] + dy[j]

                # 벽 또는 바깥
                if not is_movable(bx, by, 1, visited):
                    continue

            # 추가 금지 조건
            # 동시 같은 칸 X, 자리 바꾸기 X
            if (rx == bx and ry == by) or ((rx == blue[0] and ry == blue[1]) and (bx == red[0] and by == red[1])):
                continue

            new_visited = copy.deepcopy(visited)
            new_visited[0][rx][ry] = True
            new_visited[1][bx][by] = True
            dfs((rx, ry), (bx, by), time + 1, new_visited)


def solution(maze):
    global N, M, answer, A
    N = len(maze)
    M = len(maze[0])
    A = maze

    answer = sys.maxsize

    visited = [[[False for j in range(M)] for i in range(N)] for k in range(2)]
    red, blue = tuple(), tuple()
    for i in range(N):
        for j in range(M):
            if A[i][j] == 1:
                red = (i, j)
            elif A[i][j] == 2:
                blue = (i, j)
    visited[0][red[0]][red[1]] = True
    visited[1][blue[0]][blue[1]] = True
    dfs(red, blue, 0, visited)

    return answer if answer != sys.maxsize else 0