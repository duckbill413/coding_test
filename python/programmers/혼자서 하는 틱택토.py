def win(t, board):
    for r in board:
        if r == [t, t, t]:
            return True

    for c in range(3):
        if [board[r][c] for r in range(3)] == [t, t, t]:
            return True

    if [board[0][0], board[1][1], board[2][2]] == [t, t, t]:
        return True
    if [board[0][2], board[1][1], board[2][0]] == [t, t, t]:
        return True

    return False


def solution(board):
    board = [list(row) for row in board]

    o_count, x_count = 0, 0
    for r in board:
        for c in r:
            if c == 'O':
                o_count += 1
            elif c == 'X':
                x_count += 1

    if not (o_count == x_count or o_count == x_count + 1):
        return 0

    if win('O', board) and win('X', board):
        return 0

    if win('O', board) and o_count != x_count + 1:
        return 0

    if win('X', board) and o_count != x_count:
        return 0

    return 1
