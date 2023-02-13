# 2343 블루레이 만들기
N, M = map(int, input().split())
A = list(map(int, input().split()))

start = max(A)
end = sum(A)

while start <= end:
    mid = (start + end) // 2  # mid는 한 레코드에 들어가는 크기
    sum = 0  # 한 레코드 크기 (mid를 넘기지 않아야 함)
    count = 0  # 레코드의 개수

    for i in range(N):
        if sum + A[i] > mid:
            count += 1
            sum = 0
        sum += A[i]

    if sum != 0:
        count += 1

    if count > M:
        start = mid + 1
    else:
        end = mid - 1

print(start)