# 27. 정렬된 배열에서 특정 수의 개수 구하기

n, x = map(int, input().split())
data = list(map(int, input().split()))


def find_start(target, array, start, end):
    if start > end:
        return None

    mid = (start + end) // 2

    if (mid == 0 or target > array[mid - 1]) and array[mid] == target:
        return mid
    elif array[mid] >= target:
        return find_start(target, array, start, mid - 1)
    else:
        return find_start(target, array, mid + 1, end)


def find_end(target, array, start, end):
    if start > end:
        return None

    mid = (start + end) // 2

    if (mid == n - 1 or target < array[mid + 1]) and array[mid] == target:
        return mid
    elif array[mid] > target:
        return find_end(target, array, start, mid - 1)
    else:
        return find_end(target, array, mid + 1, end)


start = find_start(x, data, 0, n - 1)
if start is None:
    print(-1)
else:
    end = find_end(x, data, 0, n - 1)

    print(end - start + 1)
