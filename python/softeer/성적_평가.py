import sys

N = int(input())

scores = []
for i in range(3):
    score = list(map(int, input().split()))
    scores.append(score)

total = [0] * N
def print_rank(score):
    dic = {}
    idx = 0
    sorted_score = sorted(score, reverse=True)
    for s in sorted_score:
        idx += 1
        if s not in dic:
            dic[s] = idx

    rank = []
    for i in range(N):
        rank.append(dic[score[i]])
        total[i] += score[i]
    print(*rank)


for i in range(3):
    print_rank(scores[i])
print_rank(total)