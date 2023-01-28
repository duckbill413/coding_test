# 11286 절댓값 힙 구하기
import heapq
import sys

input = sys.stdin.readline

N = int(input())
pq = []

for i in range(N):
    x = int(input())
    if x == 0:
        if not pq:
            print(0)
        else:
            print(heapq.heappop(pq)[1])
    else:
        priority = abs(x) * 2 if x < 0 else abs(x) * 2 + 1
        heapq.heappush(pq, (priority, x))