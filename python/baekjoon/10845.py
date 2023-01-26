import collections
import sys
input = sys.stdin.readline

N = int(input())
q = collections.deque()
size = 0
for i in range(N):
    line = input().split()
    if line[0] == 'push':
        q.append(int(line[1]))
        size += 1
    elif line[0] == 'pop':
        if size != 0:
            print(q[0])
            q.popleft()
            size -= 1
        else:
            print(-1)
    elif line[0] == 'size':
        print(size)
    elif line[0] == 'empty':
        if size == 0:
            print(1)
        else:
            print(0)
    elif line[0] == 'front':
        if size == 0:
            print(-1)
        else:
            print(q[0])
    elif line[0] == 'back':
        if size == 0:
            print(-1)
        else:
            print(q[len(q) - 1])
