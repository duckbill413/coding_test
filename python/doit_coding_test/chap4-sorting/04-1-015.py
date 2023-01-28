# 2750 수 정렬하기 1
import sys

input = sys.stdin.readline

N = int(input())

numbers = []
for i in range(N):
    numbers.append(int(input()))

for i in range(N-1):
    for j in range(N-1-i):
        if numbers[j] > numbers[j+1]:
            numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

print(*numbers, sep='\n')