# 12850 본대 산책2
import sys

sys.setrecursionlimit(10 ** 8)
MOD = 1_000_000_007

length = 8
dp = {1: [
    [0, 1, 1, 0, 0, 0, 0, 0],
    [1, 0, 1, 1, 0, 0, 0, 0],
    [1, 1, 0, 1, 1, 0, 0, 0],
    [0, 1, 1, 0, 1, 1, 0, 0],
    [0, 0, 1, 1, 0, 1, 0, 1],
    [0, 0, 0, 1, 1, 0, 1, 0],
    [0, 0, 0, 0, 0, 1, 0, 1],
    [0, 0, 0, 0, 1, 1, 0, 0]
]}


# 왕복을 고려한 분할 정복
def find_branches(start, end, time):
    # time <= 1 인 경우 왕복이 불가능
    if time <= 1:
        return dp[1][start][end]

    # dp[time]이 한번도 설정되지 않은 경우 경우의 수를 0으로 초기화
    dp.setdefault(time, [[0] * length for _ in range(length)])
    # 만약 dp[time][start][end]가 0이 아니라면 start -> end 가 이미 한번 고려된 경우이다.
    if dp[time][start][end] != 0:
        return dp[time][start][end]

    # 중간 인덱스
    mid = time // 2
    mid_next = time // 2 if time % 2 == 0 else time // 2 + 1

    # 8개 정점에 대해서 start -> end로 가는 중 중간 경로를 나누어서 생각
    for i in range(length):
        dp[time][start][end] += find_branches(start, i, mid) * find_branches(i, end, mid_next)  # 곱연산
        dp[time][start][end] %= MOD

    return dp[time][start][end]


time = int(input())
# 원점 회귀
print(find_branches(0, 0, time))
