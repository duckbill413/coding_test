# 5710 전기 요금
import sys

input = sys.stdin.readline


def calc_fee(use):
    result = 0
    if use > 1000000:
        result += (use - 1000000) * 7
        use = 1000000
    if use > 10000:
        result += (use - 10000) * 5
        use = 10000
    if use > 100:
        result += (use - 100) * 3
        use = 100
    if use > 0:
        result += use * 2
    return result


def calc_inverse_fee(fee):
    result = 0
    if fee > 4979900:
        result += (fee - 4979900) // 7
        fee = 4979900
    if fee > 29900:
        result += (fee - 29900) // 5
        fee = 29900
    if fee > 200:
        result += (fee - 200) // 3
        fee = 200
    result += fee // 2
    return result


def binary_search(total):
    global B
    start = 0
    end = total

    while True:
        my = (start + end) // 2
        you = total - my

        diff = abs(calc_fee(my) - calc_fee(you))
        if diff == B:
            return calc_fee(my)
        elif diff > B:
            start = my + 1
        else:
            end = my - 1


while True:
    A, B = map(int, input().split())
    if A == 0 and B == 0:
        break
    total = calc_inverse_fee(A)
    print(binary_search(total))
