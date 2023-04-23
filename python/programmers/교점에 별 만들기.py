import itertools


def calc(l1, l2):
    a, b, c = l1
    x, y, z = l2

    # 기울기가 깉아 해가 없는 경우
    if x * b == a * y:
        return

        # 직선의 해
    col = (b * z - c * y) / (a * y - b * x)
    row = (c * x - a * z) / (a * y - b * x)

    if col == int(col) and row == int(row):
        return [int(col), int(row)]


def solution(line):
    points = []
    for l1, l2 in itertools.combinations(line, 2):
        point = calc(l1, l2)
        if point:
            points.append(point)

    wmin, wmax = min(points, key=lambda x: x[0])[0], max(points, key=lambda x: x[0])[0]
    hmin, hmax = min(points, key=lambda x: x[1])[1], max(points, key=lambda x: x[1])[1]

    answer = [['.' for j in range(wmax - wmin + 1)] for i in range(hmax - hmin + 1)]

    for x, y in points:
        answer[y - hmin][x - wmin] = '*'

    answer.reverse()
    return [''.join(a) for a in answer]

# line = [[2, -1, 4], [-2, -1, 4], [0, -1, 1], [5, -8, -12], [5, 8, 12]]
# line = [[0, 1, -1], [1, 0, -1], [1, 0, 1]]
line = [[1, -1, 0], [2, -1, 0]]
# line = [[1, -1, 0], [2, -1, 0], [4, -1, 0]]
print(solution(line))
