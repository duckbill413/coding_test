# 대충 만든 자판
import collections


def solution(keymap, targets):
    alphabet = collections.defaultdict(lambda: 200)

    for key in keymap:
        for i in range(len(key)):
            alphabet[key[i]] = min(alphabet[key[i]], i + 1)

    answer = []
    for target in targets:
        count = 0
        for w in target:
            if alphabet[w] == 200:
                count = -1
                break
            count += alphabet[w]
        answer.append(count)

    return answer
