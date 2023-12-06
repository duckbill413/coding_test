import itertools


def solution(k, dungeons):
    answer = 0

    for l in list(itertools.permutations(dungeons, len(dungeons))):
        health, count = k, 0
        for a, b in l:
            if health >= a:
                health -= b
                count += 1
            else:
                break
        answer = max(answer, count)
    return answer
