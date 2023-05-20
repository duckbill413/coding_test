T = int(input())

for test_case in range(1, T + 1):
    day = int(input())
    sales = list(map(int, input().split()))

    answer = 0

    base = sales[day-1]
    for i in range(day-2, -1, -1):
        if base > sales[i]:
            answer += base - sales[i]
        else:
            base = sales[i]
    print('#'+str(test_case), answer)