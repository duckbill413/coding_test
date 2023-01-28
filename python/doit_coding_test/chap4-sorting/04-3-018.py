# 11399 ATM 인출 시간 계산하기 - 삽입 정렬
import sys

input = sys.stdin.readline

N = int(input())
times = list(map(int, input().split()))

S = [0] * N
for i in range(1, N):
    insert_index = i
    insert_value = times[i]
    for j in range(i - 1, -1, -1):
        if times[j] < times[i]:
            insert_index = j + 1
            break
        if j == 0:
            insert_index = 0
    for j in range(i, insert_index, -1):
        times[j] = times[j - 1]
    times[insert_index] = insert_value

S[0] = times[0]

for i in range(1, N):
    S[i] = S[i-1] + times[i]

print(sum(S))