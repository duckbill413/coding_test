import collections

def solution(n):
    answer = 0
    sum = 0
    q = collections.deque()

    if n == 1: return 1

    start = 0
    while start <= n:
        if sum <= n:
            sum += start
            q.append(start)
            start += 1
        else:
            sum -= q.popleft()
        if sum == n:
            answer += 1

    return answer + 1

print(solution(1))