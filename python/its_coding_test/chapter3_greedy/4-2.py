N, K = map(int, input().split())

count = 0

while True:
    target = (N // K) * K
    count += (N - target)
    N = target
    if N < K:
        break
    N //= K
    count += 1

count += (N -1)
print(count)