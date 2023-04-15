# k진수에서 소수 개수 구하기
# https://school.programmers.co.kr/learn/courses/30/lessons/92335

def transform(n, k):
    t = []
    while True:
        t.append(n % k)
        n = n // k
        if n < k:
            t.append(n)
            break
    return list(reversed(t))

def isPrime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n%i==0:
            return False
    return True

def solution(n, k):
    answer = 0
    t = transform(n, k)

    number = 0
    for i in range(len(t)):
        if t[i] != 0:
            number = number * 10 + t[i]
        else:
            if isPrime(number):
                answer += 1
            number = 0
    if isPrime(number):
        answer += 1
    return answer