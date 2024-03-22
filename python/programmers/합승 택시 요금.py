import heapq

INF = int(1e9)


def dijkstra(start):
    global graph
    fee = [INF] * len(graph)
    q = []
    heapq.heappush(q, (0, start))
    fee[start] = 0

    while q:
        cur_cost, cur_node = heapq.heappop(q)

        if fee[cur_node] < cur_cost:
            continue

        for next_cost, next_node in graph[cur_node]:
            if cur_cost + next_cost < fee[next_node]:
                fee[next_node] = cur_cost + next_cost
                heapq.heappush(q, (fee[next_node], next_node))
    return fee


def solution(n, s, a, b, fares):
    global graph
    graph = [[] for _ in range(n + 1)]

    for n1, n2, c in fares:
        graph[n1].append((c, n2))
        graph[n2].append((c, n1))

    fee_s = dijkstra(s)
    minium = fee_s[a] + fee_s[b]
    fee_a = dijkstra(a)
    fee_b = dijkstra(b)

    for i in range(1, n + 1):
        minium = min(minium, fee_s[i] + fee_a[i] + fee_b[i])

    return minium
