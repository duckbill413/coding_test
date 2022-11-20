# 38. 정확한 순위
INF = int(1e9)

v, e = map(int, input().split())
graph = [[INF] * (v + 1) for _ in range(v + 1)]

for i in range(v + 1):
    graph[i][i] = i

for i in range(e):
    s, e = map(int, input().split())
    graph[s][e] = 1

for k in range(1, v + 1):
    for a in range(1, v + 1):
        for b in range(1, v + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

answer = 0
for i in range(1, v + 1):
    count = 0
    for j in range(1, v + 1):
        if graph[i][j] != INF or graph[j][i] != INF:
            count += 1
    if count == v:
        answer += 1

print(answer)


'''
6 6
1 5
3 4
4 2
4 6
5 2
5 4
'''