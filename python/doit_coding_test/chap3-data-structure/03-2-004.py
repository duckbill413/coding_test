# 11660 구간 합 구하기
import sys

input = sys.stdin.readline

N, M = map(int, input().split())
table = []
for i in range(N):
    temp = list(map(int, input().split()))
    table.append(temp)

prefix_table = []
prefix_table.append([0] * (N + 1))

for i in range(1, N + 1):
    summary = 0
    prefix_line = [0]
    for j in range(1, N + 1):
        summary += table[i - 1][j - 1]
        prefix_line.append(summary + prefix_table[i - 1][j])
    prefix_table.append(prefix_line)

for i in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    result = prefix_table[x2][y2] - prefix_table[x2][y1 - 1] - prefix_table[x1 - 1][y2] + prefix_table[x1 - 1][y1 - 1]
    print(result)
