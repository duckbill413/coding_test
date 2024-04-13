# 꼬리잡기놀이
import collections
import sys

input = sys.stdin.readline
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

N, M, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

teams = collections.defaultdict(list)
path = [[0 for j in range(N)] for i in range(N)]
team_id = 1


def in_range(x, y):
    return 0 <= x < N and 0 <= y < N


def dfs(start):
    global is_searched_all
    path[start[0]][start[1]] = team_id
    for d in range(4):
        nx, ny = start[0] + dx[d], start[1] + dy[d]
        if in_range(nx, ny) and path[nx][ny] != team_id:
            if arr[nx][ny] == 0:
                continue
            if arr[nx][ny] == 2:
                teams[team_id].append((nx, ny))
            elif arr[start[0]][start[1]] + 1 == 3:
                is_searched_all = True
                teams[team_id].append((nx, ny))
            elif not is_searched_all:
                continue
            dfs((nx, ny))


def move_head(head, team_id):
    for d in range(4):
        nx, ny = head[0] + dx[d], head[1] + dy[d]
        if in_range(nx, ny) and path[nx][ny] == team_id:
            if arr[nx][ny] == 4 or arr[nx][ny] == 3:
                return nx, ny


def move_team(team_id):
    team = teams[team_id]
    nx, ny = move_head(team[0], team_id)  # 머리가 갈 위치
    x, y = team.pop()  # 꼬리 사람의 위치
    arr[x][y] = 4
    for x, y in team:  # 꼬리 부분을 제외한 위치를 2로 표시
        arr[x][y] = 2
    arr[team[-1][0]][team[-1][1]] = 3  # 마지막 위치 최신화
    arr[nx][ny] = 1
    teams[team_id] = [(nx, ny)] + team


def check_ball(x, y, d):
    global answer
    for _ in range(N):  # 한 줄 탐색
        if arr[x][y] == 0 or arr[x][y] == 4:
            x += dx[d]
            y += dy[d]
            continue

        # arr[x][y] == 1 or 2 or 3
        team_id = path[x][y]
        team = teams[team_id]
        for k in range(len(team)):
            if team[k] == (x, y):
                answer += (k + 1) ** 2

                # 머리랑 꼬리 위치 바꾸기
                head = team[0]
                tail = team[-1]
                arr[head[0]][head[1]] = 3
                arr[tail[0]][tail[1]] = 1
                team.reverse()
                return


for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            is_searched_all = False
            teams[team_id].append((i, j))
            dfs((i, j))
            team_id += 1

answer = 0
ball_x, ball_y = 0, 0
d = 3
stage = 0
for k in range(K):
    if stage == N:
        d = (d + 1) % 4
        stage = 0
    elif stage != 0:
        ball_x += dx[d]
        ball_y += dy[d]

    for team_id in teams:
        move_team(team_id)

    check_ball(ball_x, ball_y, (d + 1) % 4)
    stage += 1 # 라운드

print(answer)
