# 성격 유형 검사하기
import collections


def solution(survey, choices):
    answer = ''
    scores = collections.defaultdict(int)

    for i in range(len(survey)):
        if choices[i] < 4:  # 비동의
            scores[survey[i][0]] += (4 - choices[i])
        elif choices[i] > 4:
            scores[survey[i][1]] += (choices[i] - 4)

    if scores['R'] >= scores['T']:
        answer += 'R'
    else:
        answer += 'T'

    if scores['C'] >= scores['F']:
        answer += 'C'
    else:
        answer += 'F'

    if scores['J'] >= scores['M']:
        answer += 'J'
    else:
        answer += 'M'

    if scores['A'] >= scores['N']:
        answer += 'A'
    else:
        answer += 'N'

    return answer
