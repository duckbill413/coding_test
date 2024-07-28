N = int(input())
A = sorted(list(map(int, input().split())))
M = int(input())
B = list(map(int, input().split()))


def is_in(target):
    start = 0
    end = len(A)

    while start < end:
        mid = (start + end) // 2

        if A[mid] >= target:
            end = mid
        else:
            start = mid + 1

    return end


answer = []
for b in B:
    idx = is_in(b)
    if idx < len(A) and A[idx] == b:
        answer.append(1)
    else:
        answer.append(0)

print(*answer, sep=' ')