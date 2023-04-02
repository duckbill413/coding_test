# 1219 오민식의 고민
'''
벨만-포드를 이용하지만 음수 사이클이 아닌 양수 사이클을 찾아야 한다.

1. 모든 에지와 관련된 정보를 가져와 다음 조건에 따라 거리 리스트의 값을 업데이트
- 시작 도시가 방문한 적이 없는 도시일 때(시작 도시 == MIN) 업데이트 하지 않는다.
- 시작 도시가 양수 사이클과 연결된 도시일 때 (도착 도시 == MAX) 도착 도시도 양수 사이클과 연결된 도시로 업데이트
- '도착 도시값 < 시작 도시값 + 도착 도시 수입 - 에지 가중치'일 때 더 많이 벌 수 있는 새로운 경로로 도착한 것이므로 값을 업데이트
'''
import sys
input = sys.stdin.readline

N, start, end, M = map(int, input().split())

edges = []
for _ in range(M):
    u, v, w = map(int, input().split())
    edges.append((u, v, w))

cities = list(map(int, input().split()))

money = [-sys.maxsize] * (N + 1)

money[start] = cities[start]

for i in range(N + 101):
    for u, v, w in edges:
        if money[u] == -sys.maxsize:
            continue
        elif money[u] == sys.maxsize:
            money[v] = sys.maxsize
        elif money[v] < money[u] - w + cities[v]:
            money[v] = money[u] - w + cities[v]
            if i >= N-1:
                money[v] = sys.maxsize

if money[end] == -sys.maxsize:
    print("gg")
elif money[end] == sys.maxsize:
    print("Gee")
else:
    print(money[end])