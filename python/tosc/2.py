# 문제1. 지뢰찾기 게임 만들기
import collections

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

# 상하좌우 탐색
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 방문 노드 기억을 위한 리스트
visited = [[[] for i in range(n)] for j in range(n)]


def bfs(start, end):
    q = collections.deque()
    q.append((start[0], start[1], -1, -1)) # 시작위치 x, 시작위치 y, 회전 방향, 회전 횟수
    visited[start[0]][start[1]].append(start)

    while q:
        x, y, prev, turn = q.popleft()

        if (x, y) == end:
            break

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or ny < 0 or nx >= n or ny >= n: # 범위를 넘어 갈시
                continue

            turnn = turn if prev == i else turn + 1 # 회전 방향이 바뀔시 + 1
            if turnn > 1:
                continue

            if len(visited[nx][ny]) == 0: # 방문하지 않은 노드일 경우 방문
                q.append((nx, ny, i, turnn)) # 다음 위치 정보와 방향, 회전 횟수를 넣는다.
                visited[nx][ny] = visited[x][y].copy()
                visited[nx][ny].append((nx, ny)) # 방문 노드를 추가


start = (max_point[1], max_point[2]) # 시작 좌표
end = (min_point[1], min_point[2]) # 종료 좌표

# 회전 방향이 최대 1회인 경우의 최단 경로는 최대 두번이 나올 수 있으므로 두번 계산해 준다.
bfs(start, end)
root1 = visited[end[0]][end[1]] # 경로
visited = [[[] for i in range(n)] for j in range(n)]
step1 = 0 # 첫 시도시 지뢰 개수
for r in root1[1:-1]:
    x, y = r
    if array[x][y] == '*':
        step1 += 1
    visited[x][y].append((x, y)) # 이전 경로는 방문하지 않기 위하여 미리 추가

bfs(start, end)

root2 = visited[end[0]][end[1]]
step2 = 0 # 두 번째 시도시 지뢰 개수
for r in root2[1:-1]:
    x, y = r
    if array[x][y] == '*':
        step2 += 1

if len(root1) == len(root2): # 두 경로의 길이가 같은 경우
    result = min(step1, step2) # 지뢰의 최솟값
else: # 같지 않을 경우 첫 번째 경로가 최단 거리가 된다.
    result = step1

print(max_point[0], min_point[0], result)