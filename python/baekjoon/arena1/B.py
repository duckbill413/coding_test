# B 끝말잇기
import collections
import sys

input = sys.stdin.readline

N = int(input().strip())
A = [input().strip() for _ in range(N)]
M = int(input().strip())
B = [input().strip() for _ in range(M)]

d = collections.defaultdict(bool)
start = end = None
index = None

if N == 1:
    print(B[0])
    exit()

for i in range(N):
    if A[i] != '?':
        d[A[i]] = True
    else:
        index = i
        if 0 < i < N - 1:
            end = A[i - 1][len(A[i - 1]) - 1]
            start = A[i + 1][0]
        elif i == N - 1:
            end = A[i - 1][len(A[i - 1]) - 1]
        else:
            start = A[i + 1][0]

for s in B:
    if s not in d:
        first = s[0]
        last = s[len(s) - 1]
        if start is None:
            if first == end:
                print(s)
                exit()
        if end is None:
            if last == start:
                print(s)
                exit()
        if first == end and last == start:
            print(s)
            exit()
