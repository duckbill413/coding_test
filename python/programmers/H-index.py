def solution(citations):
    citations.sort(reverse=True)
    answer = 0

    for idx, citation in enumerate(citations):
        if citation > answer:
            answer = idx + 1
        else:
            break

    return answer
