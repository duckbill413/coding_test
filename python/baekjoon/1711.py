# 1711 직각삼각형

import sys

input = sys.stdin.readline

N = int(input())
points = [tuple(map(int, input().split())) for _ in range(N)]


def is_valid(a, b, c):
    return a + b + c == max(a, b, c) * 2


def length(a, b):
    return (a[0] - b[0]) ** 2 + (a[1] - b[1]) ** 2


answer = 0
for i in range(N - 2):
    for j in range(i + 1, N - 1):
        for k in range(j + 1, N):
            a = length(points[i], points[j])
            b = length(points[i], points[k])
            c = length(points[j], points[k])
            if is_valid(a, b, c):
                answer += 1

print(answer)
