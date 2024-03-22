def time_to_second(time):
    h, m, s = map(int, time.split(':'))
    return h * 3600 + m * 60 + s


def second_to_time(second):
    h, m, s = second // 3600, (second % 3600) // 60, second % 60
    return f'{h:02}:{m:02}:{s:02}'


def solution(play_time, adv_time, logs):
    total_second = time_to_second(play_time)
    adv_second = time_to_second(adv_time)

    viewers = [0] * (total_second + 1)
    for log in logs:
        start, end = map(time_to_second, log.split('-'))
        viewers[start] += 1
        viewers[end] -= 1

    for i in range(1, total_second):
        viewers[i] = viewers[i] + viewers[i - 1]
    for i in range(1, total_second):
        viewers[i] = viewers[i] + viewers[i - 1]

    answer = 0
    maxium = viewers[adv_second]
    for i in range(total_second - adv_second, -1, -1):
        v = viewers[i + adv_second - 1] - viewers[i - 1]
        if maxium <= v:
            maxium = v
            answer = i

    return second_to_time(answer)
