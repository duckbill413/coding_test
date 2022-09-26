start = input()

x = int(start[1])
y = ord(start[0]) - ord('a') + 1

move = [(-2, -1), (-2, 1), (-1, -2), (1, -2), (-1, 2), (1, 2), (2, -1), (2, 1)]

count = 0
for m in move:
    nx = x + m[0]
    ny = y + m[1]

    if nx < 1 or ny < 1 or nx > 8 or ny > 8:
        continue
    count += 1

print(count)