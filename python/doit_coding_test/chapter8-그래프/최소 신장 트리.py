'''
최소 신장 트리 (minimum spanning tree)
최소 신장 트리란 그래프에서 모든 노드를 연결할 때 사용된 에지들의 가중치의 합을 최소로 하는 트리
특징)
- 사이클이 포함되면 가중치의 합이 최소가 될 수 없으므로 사이클을 포함하지 않는다.
- N개의 노드가 있으면 최소 신장 트리를 구성하는 에지의 개수는 항상 N -1 개이다.
이론)
1. 에지 리스트로 그래프를 구현하고 유니온 파인드로 리스트 초기화 하기
2. 그래프 데이터를 가중치 기준으로 정렬하기
3. 가중치가 낮은 에지부터 연결 시도하기
4. 과정 3 반복하기
5. 총 에지 비용 출력하기
'''
import heapq
def find_parent(parent, x):
    if parent[x] == x:
        return x
    else:
        parent[x] = find_parent(parent, parent[x])
        return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a != b:
        parent[b] = a

V, E = map(int, input().split())

parent = [i for i in range(V + 1)]
q = []

for i in range(E):
    s, e, w = map(int, input().split())
    heapq.heappush(q, (w, s, e))


useEdge = 0
result = 0

while useEdge < V - 1: # MST는 항상 N-1의 에지를 사용함
    w, s, e = heapq.heappop(q)
    if find_parent(parent, s) != find_parent(parent, e):
        union_parent(parent, s, e)
        result += w
        useEdge += 1

print(result)