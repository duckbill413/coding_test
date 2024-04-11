import sys

input = sys.stdin.readline

N, M, P, C, D = map(int, input().split())

rudolph = list(map(int, input().split()))

# idx: x, y, score, status
santa = {}
table = [[0 for j in range(N)] for i in range(N)]
for _ in range(P):
    idx, sr, sc = map(int, input().split())
    santa[idx] = [sr, sc, 0, True]  # x, y, score
    table[sr][sc] = idx

dx = [-1, -1, 0, 1, 1, 1, 0, -1]
dy = [0, 1, 1, 1, 0, -1, -1, -1]
INF = int(1e9)


def in_range(x, y):
    return 0 <= x < N and 0 <= y < N


def distance(x, y, a, b):
    return (x - a) ** 2 + (y - b) ** 2


def move_santa(x, y):
    d = distance(x, y, rudolph[0], rudolph[1])
    move = [x, y, d]
    for i in range(0, 8, 2):
        nx = x + dx[i]
        ny = y + dy[i]
        if distance(nx, ny, rudolph[0], rudolph[1]) < move[2]:
            move = [nx, ny, distance(nx, ny, rudolph[0], rudolph[1])]
    return move


def move_rudolph(x, y):
    # 돌진할 산타 선택하기
    choose = [INF, 0, -1, -1]  # 거리, 산타 idx, x, y
    for idx, (sx, sy, score) in santa.items():
        d = distance(x, y, sx, sy)
        if choose[0] >= d:
            if choose[2] <= sx:
                if choose[1] < sx or (choose[2] == sx and choose[3] < sy):
                    choose = [d, idx, sx, sy]

    move = [x, y, choose[0], INF]  # 루돌프 x, 루돌프 y, 거리, 방향
    for i in range(8):
        nx = x + dx[i]
        ny = y + dy[i]
        if move[2] > distance(nx, ny, choose[2], choose[3]):
            move = [nx, ny, distance(nx, ny, choose[2], choose[3]), i]

    return move


def crash(idx, d, c):  # 충돌한 산타 idx, 거리, 방향, 부딪힌 주체 (0: 루돌프, 1: 산타)
    d = (d + 8) % 4  # 이동해온 방향과 반대 방향
    score = C if c == 0 else D
    santa[idx][2] += score  # 산타 점수 증가

    nx = santa[idx][0] + dx[d] * score
    ny = santa[idx][1] + dy[d] * score

    if not in_range(nx, ny):
        santa[idx][3] = False
        return

    while nx == -1 and ny == -1:
        # 이동하려는 위치에 산타가 없는 경우
        if table[nx][ny] == 0:
            table[nx][ny] = idx
            santa[idx][0] = nx
            santa[idx][1] = ny
            nx = ny = -1
        else:
            prev_idx = table[nx][ny]
            # 산타
            table[nx][ny] = idx
            santa[idx][0] = nx
            santa[idx][1] = ny
            # 기존 산타
            nx = santa[prev_idx][0] + dx[d]
            ny = santa[prev_idx][1] + dy[d]
            santa[prev_idx]