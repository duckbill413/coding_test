import copy

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def dfs(x, y, graph, position, n, num):
    result = [position]

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx and nx < n and 0 <= ny and ny < n and graph[nx][ny] == num:
            graph[nx][ny] = 2
            result += dfs(nx, ny, graph, (position[0] + dx[i], position[1] + dy[i]), n, num)

    return result

def rotate(origin):
    # return list(map(list, zip(*origin[::-1])))
    length = len(origin)

    shape = [[0] * length for _ in range(length)]

    for i in range(length):
        for j in range(length):
            shape[length - 1 - j][i] = origin[i][j]
    return shape


def solution(game_board, table):
    answer = 0
    n = len(game_board)
    game_board_copy = copy.deepcopy(game_board)
    block = []

    for i in range(n):
        for j in range(n):
            if game_board_copy[i][j] == 0:
                game_board_copy[i][j] = 2  # 도형 선택 완료
                result = dfs(i, j, game_board_copy, (0, 0), n, 0)[1:]
                block.append(result)

    for k in range(4):
        table = rotate(table)
        table_copy = copy.deepcopy(table)

        for i in range(n):
            for j in range(n):
                if table_copy[i][j] == 1:
                    table_copy[i][j] = 2
                    result = dfs(i, j, table_copy, (0, 0), n, 1)[1:]
                    if result in block:
                        block.pop(block.index(result))
                        answer += len(result) + 1
                        table = copy.deepcopy(table_copy)
                    else:
                        table_copy = copy.deepcopy(table)
    return answer

game_board =[[1,1,0,0,1,0],[0,0,1,0,1,0],[0,1,1,0,0,1],[1,1,0,1,1,1],[1,0,0,0,1,0],[0,1,1,1,0,0]]
table =[[1,0,0,1,1,0],[1,0,1,0,1,0],[0,1,1,0,1,1],[0,0,1,0,0,0],[1,1,0,1,1,0],[0,1,0,0,0,0]]

result = solution(game_board, table)
print(result)