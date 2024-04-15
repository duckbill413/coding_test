def solution(n):
    answer = n ** 0.5
    if answer % 1 != 0:
        return -1
    return (int(answer) + 1) ** 2
