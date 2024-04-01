a, b = map(int, input().strip().split(' '))

for i in range(b):
    print(''.join(['*' for _ in range(a)]))