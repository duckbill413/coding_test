import collections


def solution(k, tangerine):
    d = collections.defaultdict(int)
    for t in tangerine:
        d[t] += 1

    size = list(d.values())
    size.sort(reverse=True)

    sum, count = 0, 0
    for s in size:
        count += 1
        sum += s
        if sum >= k:
            return count
