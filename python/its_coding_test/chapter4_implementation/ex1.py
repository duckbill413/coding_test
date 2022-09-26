N = int(input())
move = list(map(str, input().split()))

x, y = 1, 1

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
types = ['U', 'D', 'L', 'R']

for m in move:
    index = types.index(m)
    nx = x + dx[index]
    ny = y + dy[index]

    if nx < 1 or ny < 1 or nx > N or ny > N:
        continue

    x, y = nx, ny

print(x, y)