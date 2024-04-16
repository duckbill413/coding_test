# 1654 랜선 자르기
import sys

input = sys.stdin.readline

K, N = map(int, input().split())
lines = []
for _ in range(K):
    lines.append(int(input()))

start = 1
end = (1 << 32)

while start <= end:
    mid = (start + end) // 2

    count = 0
    for l in lines:
        count += l // mid

    if count < N:
        end = mid - 1
    else:
        start = mid + 1

print(end)
