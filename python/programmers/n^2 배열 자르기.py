# n^2 배열 자르기

def solution(n, left, right):
    answer = []

    for i in range(left//n, right//n+1):
        for j in range(n):
            if i == left//n and j < left % n:
                continue
            if i == right//n and j > right % n:
                break
            answer.append(max(i, j) + 1)

    return answer