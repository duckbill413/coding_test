import collections
import itertools


def solution(orders, course):
    set_menu = []

    for order in orders:
        for c in course:
            set_menu += list(itertools.combinations(sorted(order), c))

    d = {c: [2] for c in course}  # 최소 두번이상의 주문 횟수가 필요

    # print([''.join(v) for v in set_menu])
    for k, v in collections.Counter([''.join(v) for v in set_menu]).items():
        if d[len(k)][0] == v:
            d[len(k)].append(k)
        elif d[len(k)][0] < v:
            d[len(k)] = [v, k]

    answer = []
    for value in d.values():
        answer += value[1:]

    return sorted(answer)
