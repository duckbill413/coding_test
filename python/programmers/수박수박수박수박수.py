def solution(n):
    answer = '수박' * (n // 2)
    return answer if n % 2 == 0 else answer + '수'
