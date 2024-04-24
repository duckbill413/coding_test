def solution(s):
    return (len(s) == 4 or len(s) == 6) and len(list(filter(lambda x: 'A' <= x <= 'z', s))) == 0