def solution(progresses, speeds):
    answer = []

    time = 0
    cnt = 0
    for progress, speed in zip(progresses, speeds):
        if progress + time * speed >= 100:
            cnt += 1
        else:
            if cnt != 0:
                answer.append(cnt)
            time = (100 - progress) // speed
            if progress + time * speed < 100:
                time += 1
            cnt = 1
    answer.append(cnt)
    return answer
