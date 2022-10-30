# 경쟁적 전염 - 풀이
import collections

n, k = map(int, input().split())
graph = []  # 전체 보드 정보를 담는 리스트
data = []  # 바이러스 정보를 담는 리스트

for i in range(n):
    graph.append(list(map, input().split()))
    for j in range(n):
        if graph[i][j] != 0:
            # 바이러스 종류 시간 위치 삽입
            data.append((graph[i][j], 0, i, j))

data.sort()
q = collections.deque(data)

target_s, target_x, target_y = map(int, input().split())

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]

while q:
    virus, s, x, y = q.popleft()
    if s == target_s:
        break
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx and nx < n and 0 <= ny and ny < 0:
            if graph[nx][ny] == 0:
                graph[nx][ny] = virus
                q.append((virus, s + 1, nx, ny))

print(graph[target_x - 1][target_y - 1])
