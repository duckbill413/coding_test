import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[b].append(a)

def bfs(start):
    visited = set()
    visited.add(start)
    q = collections.deque([start])

    while q:
        cur = q.popleft()

        for next in graph[cur]:
            if next not in visited:
                visited.add(next)
                q.append(next)

    return len(visited)


max_count = 0
answer = []
for i in range(1, N+1):
    result = bfs(i)
    if result > max_count:
        answer = [i]
        max_count = result
    elif result == max_count:
        answer.append(i)

print(*answer, sep=' ')