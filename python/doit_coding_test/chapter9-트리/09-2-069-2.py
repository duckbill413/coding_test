# 14425 문자열 찾기
# Set을 이용하여 간단하게 하기
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
textList = set([input().strip() for _ in range(N)])

count = 0

for _ in range(M):
    subText = input().strip()
    if subText in textList:
        count += 1

print(count)