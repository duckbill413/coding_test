def solution(elements):
    answer = set()

    l = elements + elements

    for k in range(1, len(elements) + 1):
        for i in range(len(elements)):
            s = sum(l[i:i+k])
            if s not in answer:
                answer.add(s)

    return len(answer)