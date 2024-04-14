def solution(n):
    answer = list(map(str, str(n)))
    answer.sort(reverse=True)
    return int(''.join(answer))
