def solution(n, lost, reserve):
    shirts = [1] * (n + 2)
    shirts[0] = shirts[n + 1] = 0

    for l in lost:
        shirts[l] -= 1
    for r in reserve:
        shirts[r] += 1

    answer = 0
    for i in range(1, n + 1):
        # 여분의 셔츠 존재
        if shirts[i] >= 1:
            answer += 1
        else:
            if shirts[i - 1] > 1:
                answer += 1
            elif shirts[i + 1] > 1:
                shirts[i + 1] -= 1
                answer += 1
    return answer
