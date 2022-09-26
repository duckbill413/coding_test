N, K = map(int, input().split())

count = 0
while N != 1:
    if N % K == 0:
        count += 1
        N /= K
    else:
        count += 1
        N -= 1

print(count)