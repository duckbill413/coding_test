def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def solution(n, m):
    return [gcd(n, m), n * m // gcd(n, m)]
