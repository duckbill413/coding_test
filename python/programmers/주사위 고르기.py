import itertools, bisect


def game(depth, sum, id):
    global sum_list, selected, N, Dice

    if depth == N:
        sum_list[id].append(sum)
        return

    if selected[depth] != id:
        game(depth + 1, sum, id)
        return

    for i in range(6):
        game(depth + 1, sum + Dice[depth][i], id)


def solution(dice):
    global N, Dice
    N = len(dice)
    Dice = dice
    select = [i for i in range(N)]

    max_win = 0
    max_group = []
    for group in list(itertools.combinations(select, N // 2)):
        global sum_list, selected
        sum_list = [[] for _ in range(2)]
        selected = [0 if i in group else 1 for i in range(N)]

        game(0, 0, 0)  # A
        game(0, 0, 1)  # B

        sum_list[1].sort()

        # A를 기준으로 B를 이분 탐색
        win = 0
        for s in sum_list[0]:
            win += bisect.bisect_left(sum_list[1], s)

        if max_win < win:
            max_win = win
            max_group = [g + 1 for g in group]

    return max_group


dice = [[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]
print(solution(dice))
