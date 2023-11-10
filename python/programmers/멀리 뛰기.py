def solution(n):
    before = 1
    after = 2

    for i in range(1, n):
        tmp = after
        after = (before + after) % 1234567
        before = tmp

    return before