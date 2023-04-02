# 11657 타임머신으로 빨리 가기
import sys
input = sys.stdin.readline
INF = int(1e9)

N, M = map(int, input().split())

edges = []
distance = [INF] * (N+1)

for _ in range(M):
    A, B, C = map(int, input().split())
    edges.append((A, B, C))

# 벨만 포드 수행
distance[1] = 0

for _ in range(N-1):
    for start, end, time in edges:
        if distance[start] != INF and distance[end] > distance[start] + time:
            distance[end] = distance[start] + time

# 음수 사이클 확인
cycle = False

for start, end, time in edges:
    if distance[start] != INF and distance[end] > distance[start] + time:
        cycle = True
        break

if not cycle:
    for i in range(2, N+1):
        if distance[i] != INF:
            print(distance[i])
        else:
            print(-1)
else:
    print(-1)