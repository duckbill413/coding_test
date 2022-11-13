# 27. 정렬된 배열에서 특정 수의 개수 구하기
# Bisect 이용
from bisect import bisect_left, bisect_right

n, x = map(int, input().split())
data = list(map(int, input().split()))


def count_by_range(array, target):
    left = bisect_left(array, target)
    right = bisect_right(array, target)
    return right - left


answer = count_by_range(data, x)
print(-1 if answer == 0 else answer)
