def solution(n, m, section):
    answer = 0

    paint_start = -1
    for s in section:
        if paint_start != -1:  # 이전에 페인트 칠해야하는 구역이 있는 경우
            if s - paint_start + 1 > m:  # 롤러 범위를 벗어나는 경우
                answer += 1
                paint_start = s
        else:
            paint_start = s

    if paint_start != -1:
        answer += 1
    return answer
