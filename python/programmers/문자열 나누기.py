def solution(s):
    answer = 0
    start, end = 0, 0
    a, b = 0, 0

    while end < len(s):
        if s[start] == s[end]:
            a += 1
            end += 1
        else:
            b += 1
            end += 1
        if a == b:
            answer += 1
            start = end

    if a != b: answer += 1

    return answer

print(solution("abracadabra"))
