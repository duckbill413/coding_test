# 1744 수를 묶어서 최댓값 만들기
import heapq
import sys

input = sys.stdin.readline

N = int(input())

plus = []
minus = []
one = 0
zero = 0

for i in range(N):
    num = int(input())
    if num > 1:
        heapq.heappush(plus, -num)
    elif num < 0:
        heapq.heappush(minus, num)
    elif num == 1:
        one += 1
    elif num == 0:
        zero += 1

answer = 0
while len(plus) > 1:
    a = -heapq.heappop(plus)
    b = -heapq.heappop(plus)
    answer += (a * b)

while len(minus) > 1:
    a = heapq.heappop(minus)
    b = heapq.heappop(minus)
    answer += (a * b)

if plus:
    answer += -heapq.heappop(plus)

if zero == 0 and minus:
    answer += heapq.heappop(minus)

answer += one
print(answer)
