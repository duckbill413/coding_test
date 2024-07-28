import sys
import bisect

input = sys.stdin.readline

M, N = map(int, input().split())
L = sorted(list(map(int, input().split())))

start = 1
end = L[-1]


def get_count(target):
    count = 0
    for i in range(bisect.bisect_left(L, target), len(L)):
        count += L[i] // target
    return count


answer = 0
while start <= end:
    mid = (start + end) // 2

    # 사탕을 줄 수 있는 경우
    if get_count(mid) >= M:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1


print(answer)