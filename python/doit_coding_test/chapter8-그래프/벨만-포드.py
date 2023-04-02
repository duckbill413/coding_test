'''
벨만 포드
벨만 포드(bellman-ford-moore) 알고리즘은 그래프에서 최단 거리를 구하는 알고리즘으로, 주요 특징은 다음과 같다.
기능)
- 특정 출발 노드에서 다른 모든 노드까지의 최단 경로 탐색
특징)
- 음수 가중치 에지가 있어도 수행할 수 있음
- 전체 그래프에서 음수 사이클의 존재 여부를 판단할 수 있음
시간 복잡도)
O(VE)

1. 에지 리스트로 그래프를 구현하고 최단 경로 리스트 초기화하기
2. 모든 에지를 확인해 정답 리스트 업데이트 하기
- 특정 두 노드의 최단 거리를 구성할 수 있는 에지의 최대 개수는 N-1 이다.
3. 음수 사이클 유무 확인하기
- 음수 사이클을 확인하기 위해서는 모든 에지를 한 번씩 다시 사용해 업데이트되는 노드가 발생하는지 확인
- 음수 사이클이 존재하면 이 사이클을 무한하게 돌수록 가중치가 계속 감소하므로 최단 거리를 구할 수 없다.

벨만-포드 알고리즘은 최단 거리를 구하기 보다는 음수 사이클을 판별하는 문제로 더 많이 사용됨
'''
import sys
sys.setrecursionlimit(10**8)
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