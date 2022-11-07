def solution(box):
    n = len(box)
    summary = [0] * n
    summary[0] = box[0]

    for i in range(1, n):
        summary[i] = summary[i-1] + box[i]

    mean = [0] * n
    for i in range(n):
        mean[i] = summary[i] // (i+1)

    max_mean = max(mean)
    index = mean.index(max_mean)

    if summary[index] % max_mean == 0:
        return max_mean
    else:
        return max_mean + 1


box = [1, 5, 7, 2]
print(solution(box))