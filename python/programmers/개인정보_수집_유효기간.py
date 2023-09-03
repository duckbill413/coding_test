def monthAfter(day, month):
    y, m, d = map(int, day.split('.'))
    d -= 1
    if d == 0:
        m -= 1
        d = 28
    m += month
    if m > 12:
        tmp = m // 12
        y += tmp
        m -= tmp * 12
    if m == 0:
        m = 12
        y -= 1
    return f'{y:04d}.{m:02d}.{d:02d}'


def solution(today, terms, privacies):
    answer = []
    expires = {}
    for term in terms:
        a, b = term.split()
        expires[a] = int(b)

    for i in range(len(privacies)):
        a, b = privacies[i].split()
        after = monthAfter(a, expires[b])
        if today > after:
            answer.append(i + 1)

    return answer
