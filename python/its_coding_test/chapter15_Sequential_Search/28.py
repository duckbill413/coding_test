# 28. 고정점 찾기

def search(array, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2

    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return search(array, start, mid-1)
    else:
        return search(array, mid+1, end)


n = int(input())
array = list(map(int, input().split()))

print(search(array, 0, n-1))