def solution(s):
    answer = []

    tuples = []
    for w in s.split('},{'):
        tuples.append(list(map(int, w.replace('{', '').replace('}', '').split(','))))

    tuples.sort(key=len)

    for tuple in tuples:
        for t in tuple:
            if t not in answer:
                answer.append(t)
                break

    return answer