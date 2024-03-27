def solution(a, b, n):
    answer = 0

    while n >= a:
        answer += (n // a) * b
        tmp = 0
        tmp += n - (n // a) * a
        tmp += (n // a) * b
        n = tmp

    return answer
