N = int(input())

sum = 0
scores = list(map(int, input().split()))
max_score = max(scores)
for i in range(N):
    sum += scores[i] / max_score * 100

print(sum / N)