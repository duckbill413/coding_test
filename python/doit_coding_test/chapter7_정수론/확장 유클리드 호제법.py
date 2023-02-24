'''
유클리드 호제법의 목적이 두 수의 최대 공약수를 구하는 것이라면 확장 유클리드 호제법의
목적은 방정식의 해를 구하는 것입니다.

확장 유클리드 호제법에서 해를 구하고자 하는 방정식
ax + by = c(a, b, c, x, y는 정수) 일때,
위 방정식은 c % gcd(a, b) = 0 인 경우에만 정수해를 가집니다. 다시 말해 c가 a, b의 최대 공약수의 배수인 경우만
정수해를 가집니다.
이는 ax + by = c가 정수해를 갖게 하는 c의 최솟값이 gcd(a, b)라는 것을 의미합니다.
'''
# Ax + By = C일 때 이 식을 만족하는 정수 x, y를 구하라

A, B, C = map(int, input().split())


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)


def euclid(a, b):
    ret = [0] * 2
    if b == 0:
        ret[0] = 1
        ret[1] = 0
        return ret
    q = a // b
    v = euclid(b, a % b)
    ret[0] = v[1]
    ret[1] = v[0] - v[1] * q
    return ret


mgcd = gcd(A, B)

if C % gcd(A, B) != 0:
    print(-1)
else:
    mok = C // mgcd
    ret = euclid(A, B)
    print(ret[0] * mok, end=' ')
    print(ret[1] * mok)
