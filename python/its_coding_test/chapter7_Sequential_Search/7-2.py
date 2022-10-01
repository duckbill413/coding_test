# 이진 탐색
# 배열 내부가 이미 정렬된 경우 사용 가능

def binary_search(target, array, start, end):
    if start > end:
        return None

    mid = (start + end) // 2

    if array[mid] == target:
        return mid
    # 중간점의 값보다 찾고자 하는 값이 작은 경우
    elif array[mid] > target:
        return binary_search(target, array, start, mid-1)
    # 중간점의 값보다 찾고자 하는 값이 큰 경우
    else:
        return binary_search(target, array, mid+1, end)


# n(원소의 개수), target(찾고자하는 문자열) 입력
n, target = list(map(int, input().split()))
# 전체 원소 입력
array = list(map(int, input().split()))

array = sorted(array)

result = binary_search(target, array, 0, len(array)-1)

if result is None:
    print('원소가 존재하지 않습니다.')
else:
    print(result)
