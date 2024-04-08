from collections import deque

N, M = map(int, input().split())
trees = [list(map(int, input().split())) for _ in range(N)]

dx = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dy = [0, 1, 1, 0, -1, -1, -1, 0, 1]


def in_range(x, y):
    return 0 <= x < N and 0 <= y < N


def grow(x, y):
    cnt = 0
    for i in range(2, 9, 2):
        nx = x + dx[i]
        ny = y + dy[i]
        if in_range(nx, ny) and trees[nx][ny] >= 1:
            cnt += 1
    return trees[x][y] + cnt


def move(x, y, d, p):
    nx = (x + dx[d] * p) % N
    ny = (y + dy[d] * p) % N
    if nx < 0:
        nx += N
    if ny < 0:
        ny += N
    return nx, ny


q = deque([(N - 2, 0), (N - 2, 1), (N - 1, 0), (N - 1, 1)])

for i in range(M):
    d, p = map(int, input().split())  # 방향, 이동 칸 수

    # 특수 영양제를 이동
    length = len(q)
    while length > 0:
        x, y = q.popleft()
        q.append(move(x, y, d, p))
        length -= 1

    # 특수 영양제로 인한 높이 증가
    for (x, y) in q:
        trees[x][y] += 1

    remember = {}
    while q:
        x, y = q.popleft()
        remember[(x, y)] = grow(x, y)

    for x, y in remember.keys():
        trees[x][y] = remember[(x, y)]

    # 높이가 2 이상이면 잘라내고 추가
    for i in range(N):
        for j in range(N):
            if (i, j) not in remember and trees[i][j] >= 2:
                q.append((i, j))
                trees[i][j] -= 2

answer = 0
for i in range(N):
    for j in range(N):
        answer += trees[i][j]

print(answer)
