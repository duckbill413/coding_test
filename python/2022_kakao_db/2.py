def solution(cost, x):
    INF = int(1e9 + 7)

    summary = 0
    for i in reversed(range(len(cost))):
        if x >= cost[i]:
            summary += 2 ** i
            summary %= INF
            x -= cost[i]
    return summary


cost = [3, 4, 1]
x = 8
print(solution(cost, x))