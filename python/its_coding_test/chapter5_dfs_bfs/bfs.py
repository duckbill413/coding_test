import collections

visited = [False] * (10)

def bfs(graph, start, visited):
    q = collections.deque([start])
    visited[start] = True

    while q:
        now = q.popleft()

        for next in graph[now]:
            if not visited[next]:
                q.append(next)
                visited[next] = True