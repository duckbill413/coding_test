import sys

input = sys.stdin.readline

arr = []
for i in range(5):
    arr.append(int(input()))

print(sum(arr) // len(arr))
print(sorted(arr)[len(arr) // 2])