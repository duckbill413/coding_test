from collections import deque

def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True

    while queue:
        cur = queue.popleft()
        print(cur, end=' ')

        for i in graph[cur]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

graph = [[],
         [2, 3, 8],
         [1, 7],
         [1, 4, 5],
         [3, 5],
         [3, 4],
         [7],
         [2, 6, 8],
         [1, 7]]  # 인접 리스트

visited = [False] * 9

bfs(graph, 1, visited)