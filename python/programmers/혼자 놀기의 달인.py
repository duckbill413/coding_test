def game(target, group, visited):
    global N, C

    # 기선택
    if visited[target - 1]:
        return

    # 미선택
    visited[target - 1] = True
    group.append(target)
    game(C[target - 1], group, visited)


def solution(cards):
    global N, C
    N = len(cards)
    C = cards

    answer = 0

    for i in range(N // 2 + 1):
        visited = [False] * N
        group1 = []
        game(C[i], group1, visited)
        # print("g1: ", group1)
        for j in range(N):
            if not visited[C[j] - 1]:
                group2 = []
                game(C[j], group2, visited.copy())
                # print("g2: ", group2)
                answer = max(answer, len(group1) * len(group2))

    return answer
