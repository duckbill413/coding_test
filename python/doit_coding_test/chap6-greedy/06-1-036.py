# 1541 최솟값을 만드는 괄호 배치 찾기

A = list(map(str, input().split('-')))


def mySum(i):
    sum = 0
    temp = list(map(int, i.split('+')))
    for t in temp:
        sum += t
    return sum

answer = 0
for i in range(len(A)):
    temp = mySum(A[i])
    if i == 0:
        answer += temp
    else:
        answer -= temp

print(answer)