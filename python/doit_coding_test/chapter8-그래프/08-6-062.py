# 11403 경로 찾기
import sys
input = sys.stdin.readline

N = int(input())

distance = [[0 for i in range(N)] for j in range(N)]

for i in range(N):
    distance[i] = list(map(int, input().split()))

for k in range(N):
    for a in range(N):
        for b in range(N):
            if distance[a][k] == 1 and distance[k][b] == 1:
                distance[a][b] = 1

for i in range(N):
    print(*distance[i], sep=' ')