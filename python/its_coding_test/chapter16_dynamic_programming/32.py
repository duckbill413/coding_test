# 32. 정수 삼각형
n = int(input())
triangle = []
for i in range(n):
    data = list(map(int, input().split()))
    triangle.append(data)

dp = [[0] * i for i in range(1, n+1)]
dp[0][0] = triangle[0][0]
for i in range(1, n):
    for j in range(i+1):
        left = 0 if j == 0 else dp[i-1][j-1]
        right = 0 if j == i else dp[i-1][j]

        dp[i][j] = triangle[i][j] + max(left, right)

answer = 0
for i in range(n):
    answer = max(answer, dp[n-1][i])

print(answer)

'''
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
'''