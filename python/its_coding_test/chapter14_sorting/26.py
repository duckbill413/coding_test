# 26. 카드 정렬하기
import heapq

n = int(input())
data = []

for i in range(n):
    heapq.heappush(data, int(input()))

answer = 0

while len(data) != 1:
    a = heapq.heappop(data)
    b = heapq.heappop(data)
    summary = a + b
    answer += summary
    heapq.heappush(data, summary)

print(answer)