import collections


def solution(clothes):
    wears = collections.Counter([clothe[1] for clothe in clothes])

    count = 1
    for c in wears.values():
        count *= (c + 1)

    return count - 1
