def solution(n):
    primes = [True] * (n + 1)

    for i in range(2, int(n ** (1 / 2)) + 1):
        if primes[i]:
            multi = 2
            while i * multi <= n:
                primes[i * multi] = False
                multi += 1

    answer = 0
    for i in range(2, n + 1):
        if primes[i]:
            answer += 1

    return answer
