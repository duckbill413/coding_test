N, M, K = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
data.reverse()

first = data[0]
second = data[1]

sector = first * K + second
count = M // (K + 1)

total = (sector * count) + second * (M % (K + 1))

print(total)