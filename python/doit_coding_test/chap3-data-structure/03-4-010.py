# 11003 최솟값 찾기 1
import collections

N, L = map(int, input().split())
A = list(map(int, input().split()))

D = collections.deque()
# D = {0: index, 1: size}
for i in range(N):
    while D and D[-1][1] > A[i]:
        D.pop()
    D.append((i, A[i]))
    if D[0][0] <= i - L:
        D.popleft()
    print(D[0][1], end=' ')
