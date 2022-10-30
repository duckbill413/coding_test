# 17. 경쟁적 전염
import heapq

n, k = map(int, input().split())
data = []
for i in range(n):
    data.append(list(map(int, input().split())))
s, x, y = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


class node:
    def __init__(self, time, virus, row, col):
        self.time = time
        self.virus = virus
        self.row = row
        self.col = col

    def __lt__(self, other):
        if self.time < other.time: # 시간을 기준으로 오름차순
            return True
        elif self.time == other.time: # 시간이 같은 경우
            return self.virus < other.virus # 바이러스를 기준으로 오름 차순
        else:
            return False

    def getValue(self):
        return (self.time, self.virus, self.row, self.col)


q = []
for i in range(n):
    for j in range(n):
        if data[i][j] > 0:
            heapq.heappush(q, node(0, data[i][j], i, j))

while q:
    cur = heapq.heappop(q)
    cur = cur.getValue()

    if cur[0] >= s:
        continue

    for i in range(4):
        nx = cur[2] + dx[i]
        ny = cur[3] + dy[i]

        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue

        if data[nx][ny] == 0:
            data[nx][ny] = cur[1]
            heapq.heappush(q, node(cur[0] + 1, cur[1], nx, ny))

print(data[x-1][y-1])
