# 10989 수 정렬하기 3
# 기수 정렬

import sys

input = sys.stdin.readline

N = int(input())
count = [0] * 10001

for i in range(N):
    count[int(input())] += 1

for i in range(1, 10001):
    for j in range(count[i]):
        sys.stdout.write(str(i) + '\n')
