dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def solution(board, h, w):
    n = len(board)
    root = board[h][w]

    answer = 0
    for i in range(4):
        nx = h + dx[i]
        ny = w + dy[i]
        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == root:
                answer += 1
    return answer
