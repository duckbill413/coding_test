def solution(n):
    for i in range(2, 1000001):
        if n % i == 1:
            return i
