# 31. 금광
import collections


def solution(n, m, data):
    dp = [[0] * m for _ in range(n)]

    q = collections.deque()
    for i in range(n):
        q.append((i, 0))
        dp[i][0] = data[i][0]

    dx = [-1, 0, 1]
    while q:
        x, y = q.popleft()

        for i in range(3):
            nx = x + dx[i]
            ny = y + 1

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            cost = dp[x][y] + data[nx][ny]
            dp[nx][ny] = max(dp[nx][ny], cost)
            q.append((nx, ny))

    answer = 0
    for i in range(n):
        answer = max(answer, dp[i][m - 1])

    return answer


t = int(input())

while t > 0:
    n, m = map(int, input().split())
    data = list(map(int, input().split()))
    array = [[] for _ in range(n)]
    for i in range(n):
        for j in range(m):
            array[i].append(data[i*m + j])
    print(solution(n, m, array))
    t -= 1

'''
2
3 4
1 3 3 2 2 1 4 1 0 6 4 7
4 4 
1 3 1 5 2 2 4 1 5 0 2 3 0 6 1 2
'''