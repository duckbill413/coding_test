# 10799 쇠막대기

bars = list(input())

answer = 0
size = 0
for i in range(len(bars)):
    if bars[i] == '(':
        size += 1
    else:
        size -= 1
        # 레이저의 경우
        if bars[i - 1] == '(':
            answer += size
        else:
            answer += 1

print(answer)