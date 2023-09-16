# 2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임
def solution(board, moves):
    answer = 0
    N = len(board)
    M = len(board[0])
    sboard = [[] for _ in range(M + 1)]
    for i in range(N - 1, -1, -1):
        for j in range(M):
            if board[i][j] != 0:
                sboard[j + 1].append(board[i][j])

    basket = [0]
    for move in moves:
        if len(sboard[move]) == 0:
            continue
        top = sboard[move].pop()
        if basket[-1] == top:
            answer += 2
            basket.pop()
        else:
            basket.append(top)

    return answer
