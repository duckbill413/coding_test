def solution(s):
    a = list(filter(lambda x: 'A' <= x <= 'z', s))

    return len(s) == 4 or len(s) == 6 and len(list(filter(lambda x: 'A' <= x <= 'z', s))) == 0