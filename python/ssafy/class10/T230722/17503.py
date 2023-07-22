# 17503 맥주 축제
import heapq
import sys

input = sys.stdin.readline

N, M, K = map(int, input().split())
A = [tuple(map(int, input().split())) for _ in range(K)]

A.sort(key=lambda x: x[1])

my = []
preference = 0

for x, y in A:
    if len(my) < N:
        heapq.heappush(my, (x, y))
        preference += x
    elif preference < M:
        qx, qy = heapq.heappop(my)
        preference -= qx
        heapq.heappush(my, (x, y))
        preference += x
    else:
        break

if preference < M:
    print(-1)
else:
    print(max([s[1] for s in my]))