# 21567 Ax + By = C
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
