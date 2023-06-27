# 1959 두 개의 숫자열
T = int(input())
for t in range(1, T + 1):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    # A의 길이가 더 짧을 수 있게 순서 변경
    if N > M:
        A, B = B, A
        N, M = M, N

    answer = -int(1e9)
    for i in range(M - N + 1):
        result = 0
        for k in range(N):
            result += (A[k] * B[k + i])
        answer = max(answer, result)

    print(f'#{t} {answer}')
