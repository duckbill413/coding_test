# 등산코스 정하기

import heapq

INF = int(1e9)


def dijkstra(n, graph, gates, summits):
    q = []
    distance = [INF] * (n + 1)
    for gate in gates:
        distance[gate] = 0
        heapq.heappush(q, (0, gate))

    while q:
        d, c = heapq.heappop(q)

        if distance[c] < d or c in summits:
            continue

        for nn, dd in graph[c]:
            cost = max(distance[c], dd)
            if cost < distance[nn]:
                distance[nn] = cost
                heapq.heappush(q, (cost, nn))

    return distance


def solution(n, paths, gates, summits):
    summits = set(summits)
    graph = [[] for _ in range(n + 1)]
    for path in paths:
        graph[path[0]].append((path[1], path[2]))
        graph[path[1]].append((path[0], path[2]))

    result = dijkstra(n, graph, gates, summits)

    answer = [-1, INF]
    for i in range(1, n + 1):
        if i in summits and answer[1] > result[i]:
            answer = [i, result[i]]
    return answer


# n = 6
# paths = [[1, 2, 3], [2, 3, 5], [2, 4, 2], [2, 5, 4], [3, 4, 4], [4, 5, 3], [4, 6, 1], [5, 6, 1]]
# gates = [1, 3]
# summits = [5]
n = 7
paths = [[1, 2, 5], [1, 4, 1], [2, 3, 1], [2, 6, 7], [4, 5, 1], [5, 6, 1], [6, 7, 1]]
gates = [3, 7]
summits = [1, 5]
print(solution(n=n, paths=paths, gates=gates, summits=summits))
