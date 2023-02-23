# 1934 최소 공배수 구하기
T = int(input())


def get_gcd(a, b):
    mod = a
    while mod != 0:
        mod = a % b
        a, b = b, mod
    return a


def gcd_recursion(a, b):
    if b == 0:
        return a
    return gcd_recursion(b, a % b)


while T != 0:
    A, B = map(int, input().split())
    gcd = get_gcd(A, B)
    print(A * B // gcd)
    T -= 1
