def solution(s):
    answer = []

    for idx, w in enumerate(s):
        result = 0
        find = False
        for left in s[0:idx][::-1]:
            result += 1
            if w == left:
                find = True
                break
        answer.append(result) if find else answer.append(-1)
    return answer
