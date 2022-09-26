N, M, K = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
data.reverse()

first = data[0]
second = data[1]

count = 0
total = 0
for i in range(M):
    if count < K:
        total += first
        count += 1
    else:
        total += second
        count = 0

print(total)