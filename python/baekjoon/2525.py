hour, min = map(int, input().split())
plus = int(input())

hour += plus // 60
plus %= 60

min += plus
if min >= 60:
    min -= 60
    hour += 1
if hour >= 24:
    hour -= 24

print(hour, min)