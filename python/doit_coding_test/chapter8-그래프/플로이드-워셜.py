'''
플로이드-워셜 floyd-warshall
기능) 모든 노드 간에 최단 경로 탐색
특징)
- 음수 가중치 에지가 있어도 수행할 수 있음
- 동적 계획법의 원리를 이용해 알고리즘에 접근
시간 복잡도) O(V^3)
'''
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())

distance = [[sys.maxsize] * (N + 1) for _ in range(N + 1)]
for i in range(N + 1):
    distance[i][i] = 0

for _ in range(M):
    a, b, c = map(int, input().split())
    if distance[a][b] > c:
        distance[a][b] = c

for k in range(1, N + 1):
    for a in range(1, N + 1):
        for b in range(1, N + 1):
            distance[a][b] = min(distance[a][b], distance[a][k] + distance[k][b])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if distance[i][j] == sys.maxsize:
            print(0, end=' ')
        else:
            print(distance[i][j], end=' ')
    print()
