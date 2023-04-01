# 1644 소수의 연속합
N = int(input())

prime_number = [False, False] + [True] * (N-1)
prime = []

for i in range(2, N+1):
    if prime_number[i]:
        for j in range(2*i, N+1, i):
            prime_number[j] = False

for i in range(len(prime_number)):
    if prime_number[i]:
        prime.append(i)

prime.append(0)
start = -1
end = -1

count = 0
total = 0
while end < len(prime)-1:
    if total < N:
        end += 1
        total += prime[end]
    elif total > N:
        start += 1
        total -= prime[start]
    else:
        count += 1
        end += 1
        total += prime[end]

print(count)