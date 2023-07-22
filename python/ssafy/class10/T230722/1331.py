# 1331 나이트 투어
import sys

input = sys.stdin.readline
BLOCK = 36
A = []
for i in range(BLOCK):
    A.append(input().strip())

visited = [[False] * (BLOCK + 1) for _ in range(BLOCK + 1)]


def isValid(a, b, x, y):
    row = abs(a - x)
    col = abs(b - y)

    if row == 2 and col == 1:
        return True
    elif row == 1 and col == 2:
        return True
    return False;


prev_x = int(A[0][1])
prev_y = ord(A[0][0]) - ord('A') + 1
visited[prev_x][prev_y] = True

start_x = prev_x
start_y = prev_y

for i in range(1, BLOCK):
    x = int(A[i][1])
    y = ord(A[i][0]) - ord('A') + 1

    if isValid(prev_x, prev_y, x, y) and not visited[x][y]:
        visited[x][y] = True
        prev_x = x
        prev_y = y
    else:
        print('Invalid')
        exit()

if isValid(prev_x, prev_y, start_x, start_y):
    print('Valid')
else:
    print('Invalid')
