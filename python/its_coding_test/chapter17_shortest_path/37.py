# 37. 플로이드

def find_path(n, m):
    INF = int(1e9)
    graph = [[INF] * (n+1) for _ in range(n+1)]

    for i in range(n+1):
        graph[i][i] = 0

    for i in range(m):
        a, b, c = map(int, input().split())
        if c < graph[a][b]:
            graph[a][b] = c

    for k in range(1, n+1):
        for a in range(1, n+1):
            for b in range(1, n+1):
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

    for i in range(1, n+1):
        for j in range(1, n+1):
            if graph[i][j] == INF:
                graph[i][j] = 0
            print(graph[i][j], end=' ')
        print()


n = int(input())
m = int(input())

find_path(n, m)

'''
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
'''