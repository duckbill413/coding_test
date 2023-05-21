# [HSAT 1회 정기 코딩 인증평가 기출] 로봇이 지나간 경로
import sys
import collections

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]
d = ['^', '>', 'v', '<']


def check(x, y):
    start = False
    count = 0
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= M:
            continue
        if map[nx][ny] == '#':
            start = d[i]
            count += 1
    if count > 1:
        return False
    return start


def bfs(start):
    path = collections.deque()
    q = collections.deque([start])
    visited[start[0]][start[1]] = True

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            direction = d[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:
                continue
            if map[nx][ny] == '#' and not visited[nx][ny]:
                visited[nx][ny] = True
                path.append(direction)
                q.append((nx, ny))

    return path


def solve(N, M, map):
    for i in range(N):
        for j in range(M):
            if map[i][j] == '#' and check(i, j):
                path = bfs((i, j))
                print(i + 1, j + 1)  # 시작 위치
                print(path[0])  # 시작 방향

                answer = []
                cur = path.popleft()
                cnt = 1
                for p in path:
                    if p == cur:
                        cnt += 1
                        if cnt % 2 == 0:
                            answer.append('A')
                            cnt = 0
                    else:
                        if d[d.index(cur) - 1] == p:
                            answer.append('L')
                        else:
                            answer.append('R')
                        cur = p
                        cnt = 1
                return answer


if __name__ == '__main__':
    N, M = map(int, input().split())
    map = [list(input().rstrip()) for _ in range(N)]
    visited = [[False for j in range(M)] for i in range(N)]

    commands = solve(N, M, map)
    print(*commands, sep='')
