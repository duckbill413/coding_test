def solution(s):
    p = 0
    y = 0
    for w in s:
        if w.lower() == 'p':
            p += 1
        elif w.lower() == 'y':
            y += 1
    return p == y
