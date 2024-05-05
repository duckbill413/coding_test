def solution(picks, minerals):
    answer = 0
    s = 0
    for pick in picks:
        s += pick

    num = s * 5
    if len(minerals) > s:
        minerals = minerals[:num]

    m = [[0, 0, 0] for _ in range(len(minerals) // 5 + 1)]
    for i in range(len(minerals)):
        if minerals[i] == "diamond":
            m[i // 5][0] += 1
        elif minerals[i] == 'iron':
            m[i // 5][1] += 1
        elif minerals[i] == 'stone':
            m[i // 5][2] += 1

    m.sort(key=lambda x: (-x[0], -x[1], -x[2]))

    for d, i, s in m:
        for idx in range(len(picks)):
            if picks[idx] <= 0:
                continue
            if idx == 0:
                answer += d + i + s
            elif idx == 1:
                answer += d * 5 + i + s
            elif idx == 2:
                answer += d * 25 + i * 5 + s
            picks[idx] -= 1
            break

    return answer
