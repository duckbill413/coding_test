# 18110 solved.ac
import sys

input = sys.stdin.readline

def get_round(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)

N = int(input())
if N == 0:
    print(0)
    exit()
A = []
for i in range(N):
    A.append(int(input()))

s = int(get_round(N*0.15))
A.sort()
A = A[s:N-s]
print(get_round(sum(A) / len(A)))