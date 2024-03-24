import heapq


def solution(k, score):
    answer = []

    q = []
    for s in score:
        heapq.heappush(q, s)
        if len(q) > k:
            heapq.heappop(q)
        answer.append(q[0])
    return answer
