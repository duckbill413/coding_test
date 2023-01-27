# 1874 스택으로 수열 만들기
import sys

input = sys.stdin.readline

N = int(input())
result = [] # 결과 리스트
pivot = 1
s = [] # 스택

for i in range(N):
    num = int(input())

    if pivot <= num:
        while pivot <= num:
            s.append(pivot)
            pivot += 1
            result.append('+')
        s.pop()
        result.append('-')
    else:
        top = s.pop()
        if top > num:
            print('NO')
            exit()
        else:
            result.append('-')

print(*result, sep='\n')