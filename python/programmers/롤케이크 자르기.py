# 롤케이크 자르기

from collections import Counter


def solution(topping):
    answer = 0
    me = Counter(topping)
    you = set()

    for t in topping:
        me[t] -= 1
        you.add(t)

        if me[t] == 0:
            me.pop(t)

        if len(me) == len(you):
            answer += 1
    return answer
