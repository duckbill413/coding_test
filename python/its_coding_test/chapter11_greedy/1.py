# 1. 모험자 길드 - 내 풀이

N = int(input())
greedy = [0] * 100001

peoples = list(map(int, input().split()))

for people in peoples:
    greedy[people] += 1

groups = 0

for i in range(1, len(greedy)):
    groups += greedy[i] // i

print(groups)