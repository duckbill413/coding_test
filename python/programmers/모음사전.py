def solution(word):
    alpha = {
        'A': 0,
        'E': 1,
        'I': 2,
        'O': 3,
        'U': 4
    }
    distance = [781, 156, 31, 6, 1]

    answer = 0
    for idx, w in enumerate(word):
        answer += alpha[w] * distance[idx]

    answer += len(word)

    return answer
