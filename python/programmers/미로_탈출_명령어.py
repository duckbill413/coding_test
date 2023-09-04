import sys

sys.setrecursionlimit(10**8)

dx = [1, 0, 0, -1]
dy = [0, -1, 1, 0]
d = ['d', 'l', 'r', 'u']
answer = "z"


def in_range(x, y):
    return 1 <= x <= N and 1 <= y <= M


def dfs(x, y, count, path):
    global answer
    if count + abs(x - R) + abs(y - C) > K:
        return
    if x == R and y == C and count == K:
        answer = path
        return

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if in_range(nx, ny) and path <= answer:
            dfs(nx, ny, count+1, path + d[i])


def solution(n, m, x, y, r, c, k):
    global N, M, X, Y, R, C, K
    N, M, X, Y, R, C, K = n, m, x, y, r, c, k
    distance = abs(X - R) + abs(Y - C) # 최단거리
    if distance > K or (distance - K) % 2 == 1:
        return 'impossible'

    dfs(x, y, 0, "")

    return answer