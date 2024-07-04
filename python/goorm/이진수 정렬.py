N, K = map(int, input().split())
A = list(map(int, input().split()))

q = []


def count_one(n):
    c = 0
    while n > 0:
        if n % 2 == 1:
            c += 1
        n //= 2
    return c


for a in A:
    q.append((a, count_one(a)))

q.sort(key=lambda x: (-x[1], -x[0]))
print(q[K - 1][0])
