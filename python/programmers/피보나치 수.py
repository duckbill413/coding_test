def solution(n):
    mod = 1234567
    pre, cur = 0, 1

    for i in range(2, n+1):
        cur, pre = (cur + pre) % mod, cur

    return cur