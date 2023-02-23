# 1929 소수 구하기
import math
import sys

print = sys.stdout.write
M, N = map(int, input().split())

prime_number = [True] * (N + 1)
prime_number[1] = False  # 1은 소수가 아니다.

for i in range(2, int(math.sqrt(N)) + 1):
    if not prime_number[i]:
        continue
    for j in range(i + i, N + 1, i):
        prime_number[j] = False

for i in range(M, N + 1):
    if prime_number[i]:
        print(str(i) + '\n')