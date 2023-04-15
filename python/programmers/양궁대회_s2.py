def calcPoint(apeach, lion):
    apeach_score = 0
    lion_score = 0
    for i in range(11):
        if apeach[i] == lion[i] == 0:
            continue
        if apeach[i] >= lion[i]:
            apeach_score += 10 - i
        else:
            lion_score += 10 - i
    return lion_score - apeach_score

# 과녁idx, 남은 화살개수, 어피치점수, 라이언점수
def dfs(idx, n, apeach, lion):
    global answer, point
    if n < 0:
        return
    if idx > 10:
        diff = calcPoint(apeach, lion)
        if diff <= 0:
            return
        if diff > point:
            point = diff
            answer = [lion[i] for i in range(11)]
            answer[10] += n
        return

    # 상대가 쏜 점수 보다 높게 쏴본다
    lion[10-idx] = apeach[10-idx] + 1
    dfs(idx + 1, n - lion[10-idx], apeach, lion)
    lion[10-idx] = 0
    dfs(idx+1, n, apeach, lion)

def solution(n, info):
    global answer, point
    answer = [-1]
    point = 0
    dfs(0, n, info, [0 for i in range(11)])
    return answer