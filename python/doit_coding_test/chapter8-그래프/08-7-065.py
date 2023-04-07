# 17472 다리 만들기
import collections
import copy
import heapq
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
table = []
for i in range(N):
    row = list(map(int, input().split()))
    table.append(row)

visited = [[False] * M for _ in range(N)]

islandNum = 1
islandMap = []

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(i, j):
    q = collections.deque()
    island = []
    q.append((i, j))
    visited[i][j] = True
    table[i][j] = islandNum
    island.append((i, j))

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < N and ny >= 0 and ny < M:
                if not visited[nx][ny] and table[nx][ny] != 0:
                    table[nx][ny] = islandNum
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    island.append((nx, ny))
    return island


for i in range(N):
    for j in range(M):
        if table[i][j] != 0 and not visited[i][j]:
            temp = copy.deepcopy(bfs(i, j))
            islandNum += 1
            islandMap.append(temp)

pq = []

for islands in islandMap:
    for x, y in islands:
        nowNum = table[x][y]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            bridge_length = 0
            while nx >= 0 and nx < N and ny >= 0 and ny < M:
                # 같은 섬이면 에지를 만들 수 없다.
                if table[nx][ny] == nowNum:
                    break
                # 같은 섬이 아니고 바다도 아닐 경우(다리를 통해 다른 섬으로 도착)(
                elif table[nx][ny] != 0:
                    if bridge_length > 1:  # 다른 섬 -> 길이가 1 이상 이면 에지로 더하기
                        heapq.heappush(pq, (bridge_length, nowNum, table[nx][ny]))  # 다리의 길이, 출발섬, 도착섬
                    break
                # 바다인 경우
                else:
                    bridge_length += 1
                # 같은 진행 경로로 다리 건설 하기
                if nx < x:
                    nx -= 1
                elif nx > x:
                    nx += 1
                elif ny < y:
                    ny -= 1
                elif ny > y:
                    ny += 1


def find_parent(parent, x):
    if parent[x] == x:
        return x
    else:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a != b:
        parent[a] = b


parent = [i for i in range(islandNum)]
connectCnt = 1
result = 0

while pq:
    bridge_length, s, e = heapq.heappop(pq)
    if find_parent(parent, s) != find_parent(parent, e):
        union_parent(parent, s, e)
        result += bridge_length
        connectCnt += 1

if connectCnt + 1 == islandNum:
    print(result)
else:
    print(-1)
