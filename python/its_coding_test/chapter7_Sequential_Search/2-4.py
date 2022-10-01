# 부품 정렬
n = int(input())
stock_list = list(map(int, input().split()))

m = int(input())
wish_list = list(map(int, input().split()))

for wish in wish_list:
    if wish in stock_list:
        print('yes', end=' ')
    else:
        print('no', end=' ')