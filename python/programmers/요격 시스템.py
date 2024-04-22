def solution(targets):
    answer = 0

    targets.sort(key=lambda x: x[1])

    end = -1
    for s, e in targets:
        if s >= end:
            end = e
            answer += 1

    return answer
