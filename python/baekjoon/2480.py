
##2480
a, b, c = map(int, input().split())

answer = 0

if a == b == c:
    answer += 10000 + a * 1000
elif a == b or a == c or b == c:
    if a == b or a == c:
        answer += 1000 + a * 100
    else:
        answer += 1000 + b * 100
else:
    answer += max(a, b, c) * 100

print(answer)