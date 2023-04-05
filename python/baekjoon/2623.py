# 2623 음악 프로그램
import collections
import sys
input = sys.stdin.readline

N, M = map(int, input().split())

indegree = [0] * (N+1)

graph = [[] for _ in range(N+1)]

for i in range(M):
    sequence = list(map(int, input().split()))
    length = sequence[0]
    sequence = sequence[1:]
    for j in range(1, length):
        indegree[sequence[j]] += 1
        graph[sequence[j-1]].append(sequence[j])

q = collections.deque()
for i in range(1, N+1):
    if indegree[i] == 0:
        q.append(i)

result = []
while q:
    now = q.popleft()
    result.append(now)

    for member in graph[now]:
        indegree[member] -= 1
        if indegree[member] == 0:
            q.append(member)

if len(result) == N:
    print(*result, sep='\n')
else:
    print(0)