# 문제1. 지뢰찾기 게임 만들기

n = int(input())
array = []
for i in range(n):
    line = list(map(str, input()))
    array.append(line)

dx = [-1, -1, -1, 0, 0, 1, 1, 1]
dy = [-1, 0, 1, -1, 1, -1, 0, 1]

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

for i in range(n):
    print(''.join(array[i]))