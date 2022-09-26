N, M = map(int, input().split())
array = []

for i in range(N):
    array.append(min(list(map(int, input().split()))))

print(max(array))