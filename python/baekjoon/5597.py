visit = [False] * 31
for i in range(28):
    id = int(input())
    visit[id] = True

for i in range(1, 31):
    if not visit[i]:
        print(i)