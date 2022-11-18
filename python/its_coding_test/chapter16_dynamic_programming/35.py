# 35. 못생긴 수

n = int(input())
count = 1
answer = 2

while True:
    if answer % 2 == 0:
        count += 1
    elif answer % 3 == 0:
        count += 1
    elif answer % 5 == 0:
        count += 1
    if count == n:
        print(answer)
        break
    answer += 1