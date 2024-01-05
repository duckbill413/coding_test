import heapq
import sys

input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
INF = int(1e9)


def in_range(x, y):
    global N
    return 0 <= x < N and 0 <= y < N


def dijkstra(table):
    global N
    q = []
    heapq.heappush(q, (0, 0, 0))
    distance = [[INF for j in range(N)] for i in range(N)]
    distance[0][0] = 0

    while q:
        cur_cost, x, y = heapq.heappop(q)

        if distance[x][y] < cur_cost:
            continue

        for k in range(4):
            nx = x + dx[k]
            ny = y + dy[k]
            if not in_range(nx, ny):
                continue
            cost = cur_cost + table[nx][ny]
            if cost < distance[nx][ny]:
                distance[nx][ny] = cost
                heapq.heappush(q, (cost, nx, ny))

    return distance[N - 1][N - 1] + table[0][0]


def solution():
    round = 0
    while True:
        global N
        N = int(input())
        if N == 0:
            return
        round += 1

        table = []
        for i in range(N):
            table.append(list(map(int, input().split())))
        result = dijkstra(table)
        print(f'Problem {round}: {result}')


solution()
