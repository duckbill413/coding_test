# 1456 거의 소수 구하기
import math

A, B = map(int, input().split())
size = int(math.sqrt(B))
index = [True] * (size + 1)
index[1] = False

for i in range(2, int(size)+1):
    if not index[i]:
        continue
    for j in range(i*2, size+1, i):
        index[j] = False

prime_numbers = []
for i in range(1, len(index)):
    if index[i]:
        prime_numbers.append(i)

count = 0
for p in prime_numbers:
    power = p
    while p <= B / power:
        if p >= A / power:
            count += 1
        power *= p

print(count)