# 1253 '좋은 수' 구하기

N = int(input())
numbers = list(map(int, input().split()))
numbers.sort()

count = 0
for i in range(N):
    start = 0
    end = N - 1

    while start != end:
        sum = numbers[start] + numbers[end]
        if sum == numbers[i]:
            if start != i and end != i:
                count += 1
                break
            elif start == i:
                start += 1
            else:
                end -= 1
        elif sum > numbers[i]:
            end -= 1
        else:
            start += 1

print(count)