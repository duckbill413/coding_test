def solution(flowers):
    day = [0] * (366)

    for flower in flowers:
        start, end = flower[0], flower[1]
        for i in range(start, end):
            day[i] += 1

    answer = 0
    for i in range(1, 366):
        if day[i] > 0:
            answer += 1
    return answer

flowers = [[3, 4], [4, 5], [6, 7], [8, 10]]
print(solution(flowers))