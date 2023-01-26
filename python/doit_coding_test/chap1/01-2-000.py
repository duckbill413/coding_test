N = int(input())

list = []
for i in range(N):
    list.append(int(input()))

list.sort()

for i in range(N):
    print(list[i])