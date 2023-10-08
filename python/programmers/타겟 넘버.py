def dfs(depth, total):
    global answer, Numbers, Target
    if depth == len(Numbers):
        if total == Target:
            answer += 1
        return

    dfs(depth + 1, total + Numbers[depth])
    dfs(depth + 1, total - Numbers[depth])


def solution(numbers, target):
    global answer, Numbers, Target
    Numbers, Target = numbers, target
    answer = 0

    dfs(0, 0)
    return answer
