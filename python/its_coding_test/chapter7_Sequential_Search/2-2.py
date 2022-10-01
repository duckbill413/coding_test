# 부품 찾기 - 계수 정렬
n = int(input())
stock_list = [0] * 1000000

for i in input().split():
    stock_list[int(i)] += 1

m = int(input())
wish_list = list(map(int, input().split()))

for wish in wish_list:
    if stock_list[wish] > 0:
        print('yes', end=' ')
    else:
        print('no', end=' ')

'''
5
8 3 7 9 2
3
5 7 9
'''