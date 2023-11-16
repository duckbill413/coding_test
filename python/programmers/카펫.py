import math


def solution(brown, yellow):
    a = brown + 4
    b = int(math.sqrt((brown + 4) ** 2 - 16 * (brown + yellow)))

    return [(a + b) // 4, (a - b) // 4]
