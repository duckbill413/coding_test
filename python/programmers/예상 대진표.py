def game(a, b):
    count = 0

    while a != b:
        if a % 2 != 0:
            a += 1
        if b % 2 != 0:
            b += 1
        a //= 2
        b //= 2
        count += 1

    return count


def solution(n, a, b):
    return game(a, b)
