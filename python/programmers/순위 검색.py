from collections import defaultdict
from itertools import combinations
from bisect import bisect_left


def solution(info, query):
    dic = defaultdict(list)

    for i in info:
        answers = i.split()
        condition = answers[:-1]
        score = int(answers[-1])

        for k in range(5):
            for case in list(combinations([0, 1, 2, 3], k)):
                key = condition.copy()
                for c in case:
                    key[c] = '-'
                dic[''.join(key)].append(score)

    # 이진 탐색을 위한 정렬
    for d in dic.values():
        d.sort()

    answer = []
    for q in query:
        q = q.replace("and ", "").split()
        score = int(q[-1])
        key = ''.join(q[:-1])

        answer.append(len(dic[key]) - bisect_left(dic[key], score))

    return answer
