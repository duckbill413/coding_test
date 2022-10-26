# 13. 치킨 배달
import itertools # 한개의 리스트에서 모든 조합을 계산

n, m = map(int, input().split())

house = []
chicken = []
for i in range(n):
    data = list(map(int, input().split()))
    for j in range(n):
        if data[j] == 1:
            house.append((i, j))
        elif data[j] == 2:
            chicken.append((i, j))

# 모든 치킨집 중에서 m개의 치킨집을 뽑는 경우의 수
candidates = list(itertools.combinations(chicken, m))


def distance(start, end):
    row = end[0] - start[0]
    col = end[1] - start[1]
    row = row if row > 0 else -row
    col = col if col > 0 else -col
    return row + col


def get_sum(candidate):
    result = 0
    for h in house:
        tmp = int(1e9)
        for c in candidate:
            tmp = min(tmp, distance(c, h))
        result += tmp
    return result


result = int(1e9)
for candidate in candidates:
    result = min(result, get_sum(candidate))
print(result)
'''
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0 
0 0 1 0 0 
0 0 0 0 2

5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
 
'''
