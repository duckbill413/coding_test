# 1016 제곱이 아닌 수 찾기
import math

Min, Max = map(int, input().split())
Check = [False] * (Max - Min + 1)

for i in range(2, int(math.sqrt(Max)) + 1):
    Pow = i * i
    start_index = Min // Pow
    if Min % Pow != 0:
        start_index += 1
    for j in range(start_index, Max // Pow + 1):
        Check[j * Pow - Min] = True

count = 0
for i in range(Max - Min + 1):
    if not Check[i]:
        count += 1

print(count)