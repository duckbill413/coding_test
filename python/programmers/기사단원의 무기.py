def solution(number, limit, power):
    answer = 0

    weapon = []
    for n in range(1, number + 1):
        cnt = 0
        for i in range(1, int(n ** (1 / 2)) + 1):
            if n % i == 0:
                cnt += 1
                if i < n // i:
                    cnt += 1
        weapon.append(cnt)

    for w in weapon:
        if w <= limit:
            answer += w
        else:
            answer += power

    return answer
