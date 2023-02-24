# 1850 최대 공약수 구하기
def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


A, B = map(int, input().split())
one = gcd(A, B)
while one > 0:
    print(1, end='')
    one -= 1
