# 29. 공유기 설치

n, c = map(int, input().split())
houses = []
for i in range(n):
    houses.append(int(input()))

houses.sort()

start = 1
end = houses[-1] - houses[0]  # 최대 거리
answer = 0

while start <= end:
    mid = (start + end) // 2
    value = houses[0]
    count = 1

    # 공유기 설치
    for i in range(1, n):
        if houses[i] >= value + mid:
            count += 1
            value = houses[i]

    if count >= c:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1

print(start-1)