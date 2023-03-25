# 1516 개임 개발하기
import collections

N = int(input())
paths = [[] for i in range(N + 1)]
indegree = [0] * (N + 1)
building_time = [0] * (N + 1)

for i in range(1, N + 1):
    p = list(map(int, input().split()))
    building_time[i] = p[0]

    index = 1
    while True:
        tmp = p[index]
        index += 1
        if tmp == -1:
            break
        paths[tmp].append(i)
        indegree[i] += 1

q = collections.deque()

for i in range(1, N + 1):
    if indegree[i] == 0:
        q.append(i)

result = [0] * (N + 1)
while q:
    now = q.popleft()
    for next in paths[now]:
        indegree[next] -= 1
        # 시간 업데이트
        result[next] = max(result[next], result[now] + building_time[now])
        if indegree[next] == 0:
            q.append(next)

for i in range(1, N + 1):
    print(result[i] + building_time[i])