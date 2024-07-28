import bisect

N = int(input())
A = list(map(int, input().split()))
B = sorted(list(set(A)))

answer = []
for a in A:
    answer.append(bisect.bisect_left(B, a))
print(*answer, sep=' ')
