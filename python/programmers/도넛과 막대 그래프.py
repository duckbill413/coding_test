# 2024 카카오 인턴 윈터 - 도넛과 막대 그래프
import collections


def check_graph(start):
    global graph
    vertex = set()
    edge = set()

    q = collections.deque([start])
    is_cycle = False

    while q:
        cur = q.popleft()

        if cur in vertex:
            is_cycle = True

        vertex.add(cur)

        for next in graph[cur]:
            if (cur, next) not in edge:
                q.append(next)
                edge.add((cur, next))

    if not is_cycle:
        return 2

    if len(vertex) == len(edge):
        return 1

    return 3


def solution(edges):
    global graph

    size = 0
    for edge in edges:
        size = max(size, max(edge))

    in_depth = [0] * (size + 1)
    out_depth = [0] * (size + 1)
    graph = [[] for _ in range(size + 1)]

    for s, e in edges:
        graph[s].append(e)
        in_depth[e] += 1
        out_depth[s] += 1

    rnode = 0
    for node in range(1, size + 1):
        if in_depth[node] == 0 and out_depth[node] >= 2:
            rnode = node
            break

    answer = [rnode, 0, 0, 0]
    for start in graph[rnode]:
        answer[check_graph(start)] += 1
    return answer
