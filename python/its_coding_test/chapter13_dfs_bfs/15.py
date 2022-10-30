# 15. 특정 거리의 도시 찾기
import collections
import sys

input = sys.stdin.readline
n, m, k, x = map(int, input().split())
graph = [[] for i in range(n+1)]
for i in range(m):
    s, e = map(int, input().split())
    graph[s].append(e)

q = collections.deque()
distance = [-1] * (n+1)
q.append(x)
distance[x] = 0

while q:
    cur = q.popleft()

    for next in graph[cur]:
        if distance[next] == -1:
            q.append(next)
            distance[next] = distance[cur] + 1

answer = []
for i in range(1, len(distance)):
    if distance[i] == k:
        answer.append(i)

if len(answer) == 0:
    print(-1)
else:
    for ans in answer:
        print(ans)