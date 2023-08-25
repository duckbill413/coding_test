N, M = map(int, input().split())

basket = [i for i in range(N + 1)]


def swap(a, b):
    tmp = basket[a]
    basket[a] = basket[b]
    basket[b] = tmp


for _ in range(M):
    a, b = map(int, input().split())
    while a <= b:
        swap(a, b)
        a += 1
        b -= 1

print(*basket[1:], sep=' ')
