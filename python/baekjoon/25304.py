X = int(input())
N = int(input())

answer = 0
for i in range(N):
    a, b = map(int, input().split())
    answer += a * b

if X == answer:
    print('Yes')
else:
    print('No')