# 1182 부분수열의 합

N, S = map(int, input().split())
numbers = list(map(int, input().split()))
answer = 0


def sub_sum(idx, total):
    if idx >= N:
        return

    total += numbers[idx]

    if total == S:
        global answer
        answer += 1

    sub_sum(idx + 1, total)
    sub_sum(idx + 1, total - numbers[idx])


sub_sum(0, 0)
print(answer)
