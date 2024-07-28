import bisect
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = sorted(list(map(int, input().split())))
B = sorted(list(map(int, input().split())))

answer = []
for a in A:
    idx = bisect.bisect_left(B, a)
    if idx >= len(B) or B[idx] != a:
        answer.append(a)

if len(answer) == 0:
    print(0)
else:
    print(len(answer))
    print(*answer)
