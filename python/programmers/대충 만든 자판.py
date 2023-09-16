# 대충 만든 자판
import collections


def solution(keymap, targets):
    answer = []
    alpabet = collections.defaultdict(lambda: 200)

    for key in keymap:
        for i in range(len(key)):
            alpabet[key[i]] = min(alpabet[key[i]], i + 1)

    for target in targets:
        count = 0
        for w in target:
            if alpabet[w] == 200:
                count = -1
                break
            count += alpabet[w]
        answer.append(count)

    return answer
