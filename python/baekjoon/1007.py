# 1007 벡터 매칭
# 벡터 v의 크기 sqrt(x2-x1 ^ 2, y2-y1 ^2)
import itertools
import math
import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(T):
    N = int(input())
    pair = []

    x_total = 0
    y_total = 0
    for i in range(N):
        x, y = map(int, input().split())
        x_total += x
        y_total += y
        pair.append((x, y))

    result = math.inf
    combinations = list(itertools.combinations(pair, N // 2))
    for combination in combinations[:len(combinations) // 2]:
        x1_total, y1_total = 0, 0
        for x1, y1 in combination:
            x1_total += x1
            y1_total += y1

        x2_total = x_total - x1_total
        y2_total = y_total - y1_total

        result = min(result, math.sqrt((x1_total - x2_total) ** 2 + (y1_total - y2_total) ** 2))
    print(result)