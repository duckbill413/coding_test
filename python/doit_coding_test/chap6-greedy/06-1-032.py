# 11047 동전 개수의 최솟값 구하기
N, K = map(int, input().split())
A = []
for i in range(N):
    A.append(int(input()))

answer = 0
for coin in reversed(A):
    if coin <= K:
        answer += K // coin
        K = K % coin

print(answer)