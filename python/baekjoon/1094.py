import heapq

N = 64
X = int(input())

q = []
heapq.heappush(q, N)

total = N
while total > X:
    minium = heapq.heappop(q)
    if total - minium // 2 >= X:
        total -= minium // 2
        heapq.heappush(q, minium // 2)
    else:
        heapq.heappush(q, minium // 2)
        heapq.heappush(q, minium // 2)

print(len(q))
