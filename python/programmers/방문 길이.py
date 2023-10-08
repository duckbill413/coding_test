move = {
    'U': (-1, 0),
    'D': (1, 0),
    'R': (0, 1),
    'L': (0, -1)
}


def inRange(x, y):
    return -5 <= x <= 5 and -5 <= y <= 5


def solution(dirs):
    answer = 0
    visited = set()

    x, y = 0, 0
    for dir in dirs:
        nx = x + move[dir][0]
        ny = y + move[dir][1]
        if inRange(nx, ny):
            if (x, y, nx, ny) not in visited and (nx, ny, x, y) not in visited:
                visited.add((x, y, nx, ny))
                visited.add((nx, ny, x, y))
                answer += 1
            x, y = nx, ny

    return answer
