def solution(land):
    for i in range(1, len(land)):
        for idx in range(4):
            land[i][idx] += max(land[i - 1][(idx + 1) % 4], land[i - 1][(idx + 2) % 4], land[i - 1][(idx + 3) % 4])

    return max(land[-1])
