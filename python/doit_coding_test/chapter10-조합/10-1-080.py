# 13251 조약돌 꺼내기
import sys

input = sys.stdin.readline

M = int(input())
colors = list(map(int, input().split()))
K = int(input())

N = sum(colors)

probability = [0] * 51
ans = 0
for i in range(M):
    if colors[i] >= K:
        probability[i] = 1
        for j in range(K):
            probability[i] = probability[i] * (colors[i]-j) / (N - j)
        ans += probability[i]

print(ans)