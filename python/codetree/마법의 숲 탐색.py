# 삼성 2024-04-14 오후 1번

import collections

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

R, C, K = map(int, input().split())
planet = [[0 for j in range(C)] for i in range(R + 3)]
ships = {}
robots = {}
score = 0


def in_position(x):
    return x >= 4


def in_range(x, y):
    return 0 <= x < R + 3 and 0 <= y < C


def init_planet():
    global planet, ships, robots
    planet = [[0 for j in range(C)] for i in range(R + 3)]
    ships = {}
    robots = {}


def bfs(robot_id):
    global score
    x, y = ships[robot_id]
    x += dx[robots[robot_id]]
    y += dy[robots[robot_id]]

    visited = [[False for j in range(C)] for i in range(R + 3)]
    q = collections.deque()
    q.append((x, y, robot_id))
    visited[x][y] = True

    max_row = 0
    while q:
        x, y, robot_id = q.popleft()

        if max_row < x:
            max_row = x
        for d in range(4):
            nx = x + dx[d]
            ny = y + dy[d]
            if not in_range(nx, ny):
                continue
            if visited[nx][ny]:
                continue
            if robot_id == planet[nx][ny]:
                visited[nx][ny] = True
                q.append((nx, ny, robot_id))
            if planet[nx][ny] != 0 and planet[nx][ny] != robot_id:
                ex = ships[planet[x][y]][0] + dx[robots[planet[x][y]]]
                ey = ships[planet[x][y]][1] + dy[robots[planet[x][y]]]
                if (x, y) == (ex, ey):
                    visited[nx][ny] = True
                    q.append((nx, ny, planet[nx][ny]))
    score += (max_row - 2)


def new_ship(y, d, robot_id):
    robots[robot_id] = d
    ships[robot_id] = [1, y]

    while True:
        if can_move_down(robot_id):
            x, y = ships[robot_id]
            x += 1
            ships[robot_id] = [x, y]
            continue
        if can_move_left(robot_id):
            x, y = ships[robot_id]
            x += 1
            y -= 1
            ships[robot_id] = [x, y]
            robots[robot_id] = (3 + robots[robot_id]) % 4
            continue
        if can_move_right(robot_id):
            x, y = ships[robot_id]
            x += 1
            y += 1
            ships[robot_id] = [x, y]
            robots[robot_id] = (1 + robots[robot_id]) % 4
            continue
        break

    x, y = ships[robot_id]
    planet[x][y] = robot_id
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        planet[nx][ny] = robot_id

    if in_position(x):
        bfs(robot_id)
    else:
        init_planet()


def can_move_down(robot_id):
    x, y = ships[robot_id]

    x += 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny) or planet[nx][ny] != 0:
            return False
    return True


def can_move_left(robot_id):
    x, y = ships[robot_id]

    y -= 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny) or planet[nx][ny] != 0:
            return False

    x += 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny) or planet[nx][ny] != 0:
            return False
    return True


def can_move_right(robot_id):
    x, y = ships[robot_id]

    y += 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny) or planet[nx][ny] != 0:
            return False

    x += 1
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if not in_range(nx, ny) or planet[nx][ny] != 0:
            return False
    return True


for k in range(1, K + 1):  # k는 우주선 id
    y, d = map(int, input().split())
    new_ship(y - 1, d, k)

print(score)
