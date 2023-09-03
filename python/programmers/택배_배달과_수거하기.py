def solution(cap, n, deliveries, pickups):
    answer = 0
    total_delivery = total_return = 0

    for i in range(n - 1, -1, -1):
        total_delivery += deliveries[i]
        total_return += pickups[i]

        while total_delivery > 0 or total_return > 0:
            total_delivery -= cap
            total_return -= cap
            answer += (i + 1) * 2

    return answer
