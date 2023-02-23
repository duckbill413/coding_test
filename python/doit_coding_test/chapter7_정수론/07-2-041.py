# 11689 오일러 피 함수 구하기
import math

N = int(input())
result = N

for i in range(2, int(math.sqrt(N + 1)) + 1):
    if N % i == 0:
        result = result - result / i
        while N % i == 0:
            N /= i

if N > 1:
    result = result - result / N

print(int(result))
