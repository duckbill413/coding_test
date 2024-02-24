def solution(food):
    answer = '0'
    N = len(food) - 1
    for f in reversed(food):
        if f % 2 != 0:
            f -= 1
        answer = str(N) * (f // 2) + answer + str(N) * (f // 2)
        N -= 1
    return answer
