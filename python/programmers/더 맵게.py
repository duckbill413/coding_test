import heapq


def solution(scoville, K):
    pq = []
    for s in scoville:
        heapq.heappush(pq, s)

    answer = 0
    while len(pq) != 1:
        first = heapq.heappop(pq)
        if first < K:
            second = heapq.heappop(pq)
            heapq.heappush(pq, first + (second * 2))
            answer += 1

    if pq and heapq.heappop(pq) < K:
        return -1
    elif pq:
        answer += 1
    return answer
