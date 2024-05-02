import collections


def getTime(a, b):
    return (int(b[:2]) - int(a[:2])) * 60 + int(b[3:]) - int(a[3:])


def solution(plans):
    plans.sort(key=lambda x: x[1])
    q = collections.deque(plans)
    s = []

    answer = []
    while q:
        name, start, playtime = q.popleft()

        if q:
            time = getTime(start, q[0][1])
        else:
            answer.append(name)
            break

        if time >= int(playtime):
            answer.append(name)
            time -= int(playtime)
            while s and time > 0:
                name, playtime = s.pop()
                if int(playtime) <= time:
                    time -= int(playtime)
                    answer.append(name)
                else:
                    s.append([name, int(playtime) - time])
                    time = 0
        else:
            s.append([name, int(playtime) - time])

    while s:
        answer.append(s.pop()[0])

    return answer

