N = int(input())

stages = []

for i in range(N):
    s, e = map(int, input().split())
    stages.append((s, e + 1))

stages.sort(key=lambda x: x[1])

answer = 0
end = 0

for s, e in stages:
    if s >= end:
        end = e
        answer += 1

print(answer)
