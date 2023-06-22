# 20529 가장 가까운 세 사람의 심리적 거리
import collections
import itertools
import sys

input = sys.stdin.readline


def getDistance(a, b, c):
    distance = 0
    for i in range(4):
        distance += 0 if a[i] == b[i] else 1
        distance += 0 if a[i] == c[i] else 1
        distance += 0 if b[i] == c[i] else 1
    return distance


T = int(input())
for t in range(T):
    N = int(input())
    A = list(map(str, input().split()))

    if N >= 33:
        print(0)
        continue

    result = sys.maxsize
    for a, b, c in list(itertools.combinations(A, 3)):
        result = min(result, getDistance(a, b, c))
    print(result)
