def solution(price, money, count):
    result = 0

    total = 0
    for i in range(1, count+1):
        total += price * i

    if money - total < 0:
        return -(money-total)
    else:
        return 0

result = solution(3, 20, 4)
print(result)