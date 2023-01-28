# 1427 내림차순으로 자릿수 정렬하기 - 선택 정렬

numbers = list(map(int, list(input())))
size = len(numbers)
for i in range(size-1):
    small = i
    for j in range(i+1, size):
        if numbers[small] < numbers[j]:
            small = j
    numbers[i], numbers[small] = numbers[small], numbers[i]

print(*numbers, sep='')