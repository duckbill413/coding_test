# 1948 임계 경로 구하기
import collections
import sys

input = sys.stdin.readline

N = int(input())
M = int(input())
indegree = [0] * (N + 1)
graph = [[] for _ in range(N + 1)]
reverse_graph = [[] for _ in range(N + 1)]

for i in range(M):
    a, b, c = map(int, input().split())
    indegree[b] += 1
    graph[a].append((b, c))
    reverse_graph[b].append((a, c))

start, end = map(int, input().split())

q = collections.deque()
q.append(start)
result = [0] * (N + 1)

while q:
    now = q.popleft()

    for next in graph[now]:
        indegree[next[0]] -= 1
        result[next[0]] = max(result[next[0]], result[now] + next[1])
        if indegree[next[0]] == 0:
            q.append(next[0])

answer = 0
visited = [False] * (N + 1)
q.clear()
q.append(end)
visited[end] = True

while q:
    now = q.popleft()

    for next in reverse_graph[now]:
        # 1분도 쉬지 않은 도로 체크
        if result[next[0]] + next[1] == result[now]:
            answer += 1
            if not visited[next[0]]:
                visited[next[0]] = True
                q.append(next[0])

print(result[end])
print(answer)