N = int(input())
size = N ** 2
start = 1
answer = 0
while start ** 2 <= size:
    left = N - start + 1
    answer += left ** 2
    start += 1

print(answer)
