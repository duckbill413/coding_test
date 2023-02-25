# 1325 효율적으로 해킹하기
import collections
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
A = [[] for _ in range(N + 1)]

for i in range(M):
    a, b = map(int, input().split())
    A[a].append(b)

def bfs(v):
    visited[v] = True
    q = collections.deque([v])

    while q:
        now = q.popleft()

        for next in A[now]:
            if not visited[next]:
                visited[next] = True
                answer[next] += 1
                q.append(next)

answer = [0] * (N+1)

for i in range(1, N+1):
    visited = [False] * (N+1)
    bfs(i)

max_val = max(answer)
for i in range(1, N+1):
    if answer[i] == max_val:
        print(i, end = ' ')