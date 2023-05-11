# 13398 연속된 정수의 합 구하기

import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

# 오른쪽 방향 연속합 구하기
L = [0] * N
L[0] = A[0]

# 수열에서 어떠한 수도 뺴지 않을 경우의 최댓값
result = L[0]

for i in range(1, N):
    L[i] = max(A[i], L[i - 1] + A[i])
    result = max(result, L[i])

# 왼쪽 방향 연속합 구하기
R = [0] * N
R[N - 1] = A[N - 1]

for i in range(N - 2, -1, -1):
    R[i] = max(A[i], R[i + 1] + A[i])

# L[i-1] + R[i+1] 2개의 구간 합 리스트를 더하면 i번째 값을 제거한 효과를 얻음
for i in range(1, N - 1):
    temp = L[i - 1] + R[i + 1]
    result = max(result, temp)

print(result)
