# 떡볶이 떡 만들기
N, M = map(int, input().split())
rice_cake = list(map(int, input().split()))

result = 0
start = 0
end = max(rice_cake)

while start <= end:
    total = 0
    mid = (start + end) // 2

    for r in rice_cake:
        if r > mid:
            total += r - mid

    if total < M:
        end = mid -1
    else:
        result = mid
        start = mid + 1

print(result)