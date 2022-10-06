# 4. 커리큘럼
'''
위상 정렬 - 선수과목
'''
import copy
import sys
from collections import deque

input = sys.stdin.readline

N = int(input())
time = [0] * (N+1)
graph = [[] for i in range(N+1)]
indegree = [0] * (N+1)

for i in range(1, N+1):
    tmp = list(map(int, input().split()))
    time[i] = tmp[0]
    for j in range(1, len(tmp)-1):
        indegree[i] += 1
        graph[tmp[j]].append(i)

def topoloy_sort():
    result = copy.deepcopy(time)
    q = deque()

    for i in range(1, N+1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()

        for next in graph[now]:
            result[next] = max(result[next], result[now] + time[next])
            indegree[next] -= 1
            if indegree[next] == 0:
                q.append(next)

    for i in range(1, N+1):
        print(result[i])


topoloy_sort()


'''
5
10 -1
10 1 -1
4 1 -1
4 3 1 -1
3 3 -1
'''