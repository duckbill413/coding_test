def solution(n):
    answer = []
    for i in list(reversed(str(n))):
        answer.append(int(i))
    return answer
