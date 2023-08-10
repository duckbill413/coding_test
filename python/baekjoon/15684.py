# 15684 사다리 조작
import sys

input = sys.stdin.readline

N, M, H = map(int, input().split())
ladders = [[False for j in range(N)] for i in range(H)]

for _ in range(M):
    a, b = map(int, input().split())
    ladders[a - 1][b - 1] = True


def check():
    for start in range(N):
        now = start
        for j in range(H):
            if ladders[j][now]:  # 오른쪽 이동
                now += 1
            elif now > 0 and ladders[j][now - 1]:  # 왼쪽 이동
                now -= 1
        if now != start:
            return False
    return True


def dfs(start, count):
    global answer
    if check():
        answer = min(answer, count)
        return
    elif count == 3 or answer <= count:
        return

    for i in range(start[0], H):
        if i == start[0]:
            now = start[1]
        else:
            now = 0
        for j in range(now, N - 1):
            if not ladders[i][j] and not ladders[i][j + 1]:  # 오른쪽에 사다리가 존재하지 않는 경우
                if j > 0 and ladders[i][j - 1]:  # 왼쪽에 사다리가 있는 경우 패스
                    continue
                ladders[i][j] = True
                dfs((i, j + 2), count + 1)
                ladders[i][j] = False


answer = 4
dfs((0, 0), 0)
print(answer if answer < 4 else -1)

'''
6 5 6
1 1
3 2
1 3
2 5
5 5
'''
