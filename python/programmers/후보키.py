from itertools import combinations


def solution(relation):
    columns = [i for i in range(len(relation[0]))]
    keys = []

    # 유일성을 만족하는 keys 추출
    for size in range(1, len(relation[0]) + 1):
        for case in list(combinations(columns, size)):
            fields = set()
            for r in relation:
                fields.add(''.join([r[c] for c in case]))
            if len(fields) == len(relation):
                keys.append(case)

    used_key = []
    for k in keys:
        count = 0
        for uk in used_key:
            if not set(uk).issubset(set(k)):
                count += 1
        if count == len(used_key):
            used_key.append(k)

    return len(used_key)
