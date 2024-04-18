def solution(s):
    answer = list(s)

    index = 0
    for i in range(len(answer)):
        if answer[i] == ' ':
            index = 0
            continue
        answer[i] = answer[i].upper() if index % 2 == 0 else answer[i].lower()
        index += 1

    return ''.join(answer)
