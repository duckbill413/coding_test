import collections


def solution(participant, completion):
    race = collections.defaultdict(int)

    for c in completion:
        race[c] += 1

    for p in participant:
        if race[p] == 0:
            return p
        else:
            race[p] -= 1
