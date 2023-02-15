# 1715 카드 정렬하기
import heapq
import sys

input = sys.stdin.readline
N = int(input())
A = []
for i in range(N):
    heapq.heappush(A, int(input()))

answer = 0
while len(A) > 1:
    a = heapq.heappop(A)
    b = heapq.heappop(A)

    answer += (a + b)
    heapq.heappush(A, a + b)

print(answer)
