# 21. 인구이동
import collections

n, l, r = map(int, input().split())
data = []
for i in range(n):
    tmp = list(map(int, input().split()))
    data.append(tmp)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

result = 0
def process(start, index):
    united = []
    united.append(start)

    q = collections.deque()
    q.append(start)
    union[start[0]][start[1]] = index
    summary = data[start[0]][start[1]]
    count = 1

    while q:
        now = q.popleft()

        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]

            if 0 <= nx < n and 0<= ny < n and union[nx][ny] == -1:
                if l <= abs(data[now[0]][now[1]] - data[nx][ny]) <= r:
                    q.append((nx, ny))
                    union[nx][ny] = index
                    summary += data[nx][ny]
                    count += 1
                    united.append((nx, ny))

    for i, j in united:
        data[i][j] = summary // count

total_count = 0

while True:
    union = [[-1] * n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j] == -1:
                process((i, j), index)
                index += 1
    if index == n*n:
        break
    total_count += 1

print(total_count)

'''
2 20 50
50 30
20 40
'''