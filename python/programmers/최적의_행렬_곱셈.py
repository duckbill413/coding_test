import math


def solution(matrix_sizes):
    table = [[math.inf for j in range(len(matrix_sizes))] for i in range(len(matrix_sizes))]

    for i in range(len(matrix_sizes)):
        table[i][i] = 0

    for gap in range(1, len(matrix_sizes)):
        for start in range(len(matrix_sizes)):
            end = start + gap
            if end >= len(matrix_sizes): continue

            for sep in range(start, end):
                table[start][end] = min(table[start][end],
                                        table[start][sep] + table[sep + 1][end] +
                                        (matrix_sizes[start][0] * matrix_sizes[sep][1] * matrix_sizes[end][1]))
    return table[0][-1]


print(solution([[5, 3], [3, 10], [10, 6]]))
