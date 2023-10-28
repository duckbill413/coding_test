import collections


def solution(priorities, location):
    q = collections.deque()
    for i in range(len(priorities)):
        q.append((priorities[i], i))

    priorities.sort(key=lambda x: -x)

    idx = 0
    while idx < len(priorities):
        p = priorities[idx]
        while True:
            process = q.popleft()
            if p == process[0]:
                if process[1] == location:
                    return idx + 1
                break
            else:
                q.append(process)
        idx += 1


p = [1, 1, 9, 1, 1, 1]
l = 0
print(solution(p, l))