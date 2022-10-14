# 2. 곱하기 혹은 더하기
s = input()

result = 0

for i in s:
    if result == 0:
        result += int(i)
        continue

    if int(i) <= 1:
        result += int(i)
    else:
        result *= int(i)

print(result)