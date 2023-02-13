# 1920 원하는 정수 찾기
import sys

print = sys.stdout.write
N = int(input())
A = list(map(int, input().split()))

M = int(input())
A.sort()


def find_number(find, start, end):
    if start > end:
        print('0\n')
        return

    mid = (start + end) // 2

    if A[mid] == find:
        print('1\n')
        return
    elif A[mid] < find:
        return find_number(find, mid + 1, end)
    else:
        return find_number(find, start, mid - 1)


B = list(map(int, input().split()))
for num in B:
    find_number(num, 0, N - 1)
