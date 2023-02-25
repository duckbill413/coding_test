# 18352 특정 거리의 도시 찾기
import collections
import sys

input = sys.stdin.readline

N, M, K, X = map(int, input().split())
A = [[] for _ in range(N + 1)]
dist = [-1] * (N + 1)

for i in range(M):
    s, e = map(int, input().split())
    A[s].append(e)

q = collections.deque()
q.append(X)
dist[X] = 0

while q:
    now = q.popleft()

    for next in A[now]:
        if dist[next] == -1:
            dist[next] = dist[now] + 1
            q.append(next)

answer = []
for i in range(1, N + 1):
    if dist[i] == K:
        answer.append(i)

if not answer:
    print(-1)
else:
    answer.sort()
    for i in answer:
        print(i)
