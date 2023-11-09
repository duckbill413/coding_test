def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


def lcm(a, b):
    return a * b // gcd(a, b)


def solution(arr):
    answer = 1

    for a in arr:
        answer = lcm(answer, a)

    return answer
