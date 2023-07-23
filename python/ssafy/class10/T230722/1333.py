# 1333 부재중 전화

import sys

input = sys.stdin.readline

N, L, D = map(int, input().split())

music = bell = 0
count = 1

while D * count <= N * (L + 5) - 5:
    if L <= D * count % (L + 5) < L + 5:
        music = D * count
        print(music)
        exit()
    count += 1

print(((N * (L + 5) - 5) // D + 1) * D)