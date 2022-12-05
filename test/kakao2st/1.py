def solution(infos, m):
    length = len(infos)
    INF = int(1e9)
    dp = [[0] * (length + 1) for _ in range(4)]
    for i in range(4):
        dp[i][0] = infos[0][i]

    bm, pm = m, m
    if dp[2][0] == -1:
        if dp[3][0] <= m:
            dp[2][0] = dp[3][0]
            pm -= dp[3][0]
        else:
            dp[2][0] = INF

    for i in range(1, length):
        car_time, bike_time, public_time, walk_time = infos[i]
        dp[0][i] = dp[0][i-1] + car_time
        dp[3][i] = dp[3][i-1] + walk_time

        # 대중교통 이용 불가시 대처
        if public_time == -1 and walk_time > m:
            dp[2][i] = INF
        elif public_time == -1:
            pm -= walk_time
            dp[2][i] = dp[2][i-1] + walk_time
        else:
            if public_time < walk_time or walk_time > pm:
                dp[2][i] = dp[2][i-1] + public_time
                pm = m
            else:
                dp[2][i] = dp[2][i-1] + walk_time
                pm -= walk_time

        if bike_time < walk_time or walk_time > bm:
            dp[1][i] = dp[1][i-1] + bike_time
            bm = m
        else:
            dp[1][i] = dp[1][i-1] + walk_time
            bm -= walk_time

    if dp[3][length-1] > m:
        dp[3][length-1] = INF

    answer = min(dp[0][length-1], dp[1][length-1], dp[2][length-1], dp[3][length-1])

    return answer


# infos = [[20, 40, -1, 60], [50, 20, 40, 30], [10, 30, 10, 20], [40, 10, 30, 50]]
# m = 60
infos = [[100, 80, 10, 20], [100, 60, -1, 40]]
m = 30
print(solution(infos, m))
