money = int(input())
count = 0

list = [500, 100, 50, 10]

for coin in list:
    count += money // coin
    money %= coin

print(count)