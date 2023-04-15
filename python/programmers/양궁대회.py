from itertools import combinations_with_replacement as cwr
from collections import Counter

def combinations(n, info):
    global answer, max_point
    for combi in cwr(range(11), n):
        cnt = Counter(combi)
        apeach, lion = 0, 0

        for i in range(11):
            if info[10-i] < cnt[i]:
                lion += i
            elif info[10-i] > 0:
                apeach += i
        if lion-apeach > max_point:
            max_point = lion-apeach
            for i in range(11):
                answer[10-i] = cnt[i]

def solution(n, info):
    global answer, max_point
    answer = [0] * (11)
    max_point = 0
    combinations(n, info)
    if max_point == 0:
        return [-1]
    return answer

n = 5
info = [2,1,1,1,0,0,0,0,0,0,0]

# n = 1
# info = [1,0,0,0,0,0,0,0,0,0,0]
#
# n = 9
# info = [0,0,1,2,0,1,1,1,1,1,1]
#
# n = 10
# info = [0,0,0,0,0,0,0,0,3,4,3]

answer = solution(n, info)
print(answer)