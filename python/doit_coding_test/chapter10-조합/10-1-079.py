# 1010 다리 놓기
import sys
input = sys.stdin.readline

T = int(input())
site = [[0 for j in range(31)] for i in range(31)]

for i in range(31):
    site[i][i] = 1
    site[i][1] = i
    site[i][0] = 1

for i in range(2, 31):
    for j in range(1, i):
        site[i][j] = site[i-1][j] + site[i-1][j-1]

for _ in range(T):
    N, M = map(int, input().split())
    print(site[M][N])