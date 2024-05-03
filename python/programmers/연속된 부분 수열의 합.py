def solution(sequence, k):
    plus = [0] * len(sequence)
    plus[0] = sequence[0]
    for idx, s in enumerate(sequence[1:]):
        plus[idx + 1] = plus[idx] + s
    plus = [0] + plus

    min_length = int(1e9)
    start = 0
    end = 0

    answer = [int(1e9), -1]
    while end != (len(sequence) + 1):
        s = plus[end] - plus[start]
        if s < k:
            end += 1
        elif s > k:
            start += 1
        else:
            if min_length > end - start:
                min_length = end - start
                answer = [start, end]
            end += 1

    return [answer[0], answer[1] - 1]
