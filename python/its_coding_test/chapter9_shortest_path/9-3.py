# 플로이드 워셜 알고리즘
INF = int(1e9)

# 노드의 개수 및 간선의 개수 입력
n = int(input())
m = int(input())

# 2차원 리스트를 만들고, 모든 값을 무한으로 초기화
graph = [[INF] * (n+1) for i in range(n+1)]

# 자기 자신에서 자기 자신으로 가는 비용 초기화(0)
for i in range(1, n+1):
    graph[i][i] = 0

# 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
import sys
input = sys.stdin.readline

for i in range(m):
    s, e, c = map(int, input().split())
    graph[s][e] = c

# 점화식에 따라 플로이드 워셜 알고리즘 수행
for k in range(1, n+1):
    for a in range(1, n+1):
        for b in range(1, n+1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])


# 수행된 결과 출력
for a in range(1, n+1):
    for b in range(1, n+1):
        if graph[a][b] == INF:
            print("INFINITY", end= ' ')
        else:
            print(graph[a][b], end= ' ')
    print()


'''
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
'''