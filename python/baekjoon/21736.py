# 21736 헌내기는 친구가 필요해
import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N, M = map(int, input().split())
A = []
for i in range(N):
    A.append(list(input()))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

visited = [[False] * M for _ in range(N)]
answer = 0
def dfs(start):
    global answer
    visited[start[0]][start[1]] = True

    if A[start[0]][start[1]] == 'P':
        answer += 1

    for i in range(4):
        nx = start[0] + dx[i]
        ny = start[1] + dy[i]

        if nx >= 0 and nx < N and ny >= 0 and ny < M:
            if not visited[nx][ny] and A[nx][ny] != 'X':
                dfs((nx, ny))

for i in range(N):
    for j in range(M):
        if A[i][j] == 'I':
            dfs((i, j))
if answer == 0:
    print('TT')
else:
    print(answer)