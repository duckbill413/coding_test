N = int(input())

array = []
for i in range(N):
    tmp = input().split()
    array.append((tmp[0], int(tmp[1])))


def setting(data):
    return data[1]


# array.sort(key=setting)
array.sort(key=lambda s: s[1])

for i in range(N):
    print(array[i][0], end=' ')
