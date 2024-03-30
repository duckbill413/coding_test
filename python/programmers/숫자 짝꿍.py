def solution(X, Y):
    answer = ''

    a = [0] * 10
    b = [0] * 10

    for x in X:
        a[int(x)] += 1
    for y in Y:
        b[int(y)] += 1

    for i in range(9, -1, -1):
        time = min(a[i], b[i])
        if time > 0 and i == 0 and len(answer) == 0:
            answer += '0'
            break
        if time > 0:
            answer += ''.join([str(i) for _ in range(time)])

    return answer if len(answer) > 0 else '-1'
