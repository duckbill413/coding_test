# 부품 찾기 - 이진 탐색
N = int(input())
stock_list = list(map(int, input().split()))
M = int(input())
wish_list = list(map(int, input().split()))

stock_list = sorted(stock_list)


def binary_search(target, array, start, end):
    if start > end:
        return 'no'

    mid = (start + end) // 2

    if array[mid] == target:
        return 'yes'
    elif array[mid] > target:
        return binary_search(target, array, start, mid-1)
    else:
        return binary_search(target, array, mid+1, end)


for wish in wish_list:
    print(binary_search(wish, stock_list, 0, len(stock_list)-1), end=' ')