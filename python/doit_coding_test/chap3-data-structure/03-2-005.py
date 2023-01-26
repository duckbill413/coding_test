# 10986 나머지 합 구하기

N, M = map(int, input().split())
numbers = list(map(int, input().split()))
S = [0] * N  # 구간합
C = [0] * M  # 나머지의 개수
S[0] = numbers[0]

for i in range(1, N):
    S[i] = S[i - 1] + numbers[i]

answer = 0
for i in range(N):
    remain = S[i] % M
    if remain == 0:
        answer += 1
    C[remain] += 1

for i in range(M):
    # 나머지 같은 인덱스 중 2개를 뽑는 경우의 수를 더하기
    if C[i] > 1:
        answer += C[i] * (C[i] - 1) // 2

print(answer)