# 부품 정렬 - Set 함수 사용
n = int(input())
# 집합(set) 자료형에 기록
stock_list = set(map(int, input().split()))

m = int(input())
wish_list = list(map(int, input().split()))

for wish in wish_list:
    if wish in stock_list:
        print('yes', end=' ')
    else:
        print('no', end=' ')