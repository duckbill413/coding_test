def solution(k, m, score):
    answer = 0

    score.sort(reverse=True)

    for i in range(m, len(score) + 1, m):
        answer += m * score[i - m:i][-1]

    return answer
