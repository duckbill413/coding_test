# 1300 배열에서 K번째 수 찾기

N = int(input())
K = int(input())

start = 1
end = K
answer = 0

# 작은 수의 개수가 K - 1 개인 중앙값이 정답
while start <= end:
    mid = (start + end) // 2
    cnt = 0

    for i in range(1, N + 1):
        cnt += min(mid // i, N)

    if cnt < K:
        start = mid + 1
    else:
        answer = mid
        end = mid - 1

print(answer)
