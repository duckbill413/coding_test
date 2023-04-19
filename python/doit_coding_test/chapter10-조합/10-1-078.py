# 2775 부녀회장이 될 테야
import sys

input = sys.stdin.readline

T = int(input())

A = [[j for j in range(15)] for i in range(15)]
for i in range(15):
    A[0][i] = i

for i in range(1, 15):
    for j in range(1, 15):
        A[i][j] = A[i - 1][j] + A[i][j - 1]

while T:
    floor = int(input())
    room = int(input())
    print(A[floor][room])
    T -= 1
