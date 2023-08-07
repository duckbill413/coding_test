# 28433 게리맨더링
# TODO 다시 풀기
import sys

input = sys.stdin.readline

T = int(input())


def solve(A):
    r = s = 0

    def cut():
        nonlocal r, s
        if s > 0:
            r += 1
        elif s < 0:
            r -= 1
        s = 0

    for a in A:
        if (s > 0) + (a > 0) + (s + a <= 0) >= 2:
            cut()
        s += a
    cut()

    return r >= 1


for test_case in range(T):
    N = int(input())
    A = list(map(int, input().strip().split()))
    if solve(A):
        print('YES')
    else:
        print('NO')
