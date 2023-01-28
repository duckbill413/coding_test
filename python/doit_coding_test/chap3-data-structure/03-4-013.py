# 2164 카드 게임
import collections

N = int(input())
q = collections.deque()
for i in range(N):
    q.append(i+1)

while len(q) > 1:
    q.popleft()
    q.append(q.popleft())

print(q[0])