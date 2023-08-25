import sys

print = sys.stdout.write

N = int(input())
count = (N - 4) // 4

for i in range(count):
    print('long ')
print('long int')