# 3190. 뱀
import collections
import sys

input = sys.stdin.readline

n = int(input())
k = int(input())
apples = []
for i in range(k):
    x, y= map(int, input().split())
    apples.append((x-1, y-1))
l = int(input())
rotate = collections.deque()
for i in range(l):
    x, y = map(str, input().split())
    rotate.append((int(x), y))

board = [[0] * n for _ in range(n)]  # 보드

# 사과의 위치 보드에 저장
for apple in apples:
    x, y = apple
    board[x][y] = 1 # 사과의 위치

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

time = 0
direction = 3
snake = collections.deque()
snake.append((0, 0))
while True:
    if len(rotate) != 0:
        if time == rotate[0][0]:
            r = rotate.popleft()
            if r[1] == 'L':
                direction = direction + 1 if direction < 3 else 0
            elif r[1] == 'D':
                direction = direction - 1 if direction > 0 else 3

    nx = snake[0][0] + dx[direction]
    ny = snake[0][1] + dy[direction]
    # 이동할 좌표가 벽 또는 자기자신의 몸과 부딪힌다면 반복문 종료
    if nx < 0 or ny < 0 or nx >= n or ny >= n or (nx, ny) in snake:
        time += 1
        break
    # 사과가 있는 경우
    if board[nx][ny] == 1:
        board[nx][ny] = 0
        snake.appendleft((nx, ny))
    # 사과가 없는 경우
    else:
        snake.pop()
        snake.appendleft((nx, ny))

    time += 1

print(time)

'''
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D

10
4
1 2
1 3
1 4
1 5
4
8 D
10 D
11 D
13 L

10
5
1 5
1 3
1 2
1 6
1 7
4
8 D
10 D
11 D
13 L
'''