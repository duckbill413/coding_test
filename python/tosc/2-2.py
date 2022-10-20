# 문제1. 지뢰찾기 게임 만들기
n = int(input())
array = []
for i in range(n):
    line = list(map(str, input()))
    array.append(line)

# 상하좌우대각선
dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

# 지뢰의 개수 카운팅
for i in range(n):
    for j in range(n):
        count = 0
        if array[i][j] == '*':
            continue

        for k in range(8):
            nx = i + dx[k]
            ny = j + dy[k]

            if nx < 0 or ny < 0 or nx >= n or ny >= n:
                continue
            if array[nx][ny] == '*':
                count += 1
        array[i][j] = str(count)

min_point = [10, 0, 0] # 주위의 지뢰 개수, x 좌표, y 좌표
max_point = [-1, 0, 0]

# 지뢰가 가장 적은 곳과 많은 곳의 위치 탐색
for i in range(n):
    for j in range(n):
        if array[i][j] == '*':
            continue

        if int(array[i][j]) < min_point[0]:
            min_point = [int(array[i][j]), i, j]
        if int(array[i][j]) > max_point[0]:
            max_point = [int(array[i][j]), i, j]

start = [max_point[1], max_point[2]] # 시작 좌표
end = [min_point[1], min_point[2]] # 종료 좌표

result = [0, 0]
# 경로 1 가로 이동
x = 1 if start[0] < end[0] else -1
point = start.copy()
for i in range(start[0], end[0], x):
    point[0] += x
    if (array[point[0]][point[1]] == '*'):
        result[0] += 1

# 경로 1 세로 이동
y = 1 if start[1] < end[1] else -1
for i in range(start[1], end[1], y):
    point[1] += y
    if (array[point[0]][point[1]] == '*'):
        result[0] += 1

# 경로 2 세로 이동
point = start.copy()
y = 1 if start[1] < end[1] else -1
for i in range(start[1], end[1], y):
    point[1] += y
    if (array[point[0]][point[1]] == '*'):
        result[1] += 1

# 경로 2 가로 이동
x = 1 if start[0] < end[0] else -1
for i in range(start[0], end[0], x):
    point[0] += x
    if (array[point[0]][point[1]] == '*'):
        result[1] += 1

print(max_point[0], min_point[0], min(result))