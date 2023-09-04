# 표 병합
import collections


def find_parent(parent, r, c):
    if parent[r][c] == (r, c):
        return r, c

    parent[r][c] = find_parent(parent, parent[r][c][0], parent[r][c][1])
    return parent[r][c]


def union_parent(parent, data, r1, c1, r2, c2):
    (r1, c1) = find_parent(parent, r1, c1)
    (r2, c2) = find_parent(parent, r2, c2)

    if (r1, c1) != (r2, c2):
        if data[(r1, c1)] == '':
            parent[r1][c1] = (r2, c2)
        else:
            parent[r2][c2] = (r1, c1)


def solution(commands):
    answer = []
    parent = [[(i, j) for j in range(51)] for i in range(51)]
    data = collections.defaultdict(str)

    for command in commands:
        order = list(map(str, command.split()))
        if order[0] == 'UPDATE':
            if len(order) == 4:
                r, c = find_parent(parent, int(order[1]), int(order[2]))
                data[(r, c)] = order[3]
            elif len(order) == 3:
                for key in data.keys():
                    if data[key] == order[1]:
                        data[key] = order[2]

        elif order[0] == 'MERGE':
            if find_parent(parent, int(order[1]), int(order[2])) != find_parent(parent, int(order[3]), int(order[4])):
                union_parent(parent, data, int(order[1]), int(order[2]), int(order[3]), int(order[4]))
        elif order[0] == 'UNMERGE':
            r, c = find_parent(parent, int(order[1]), int(order[2]))
            prev_data = data[(r, c)]
            unmerge_list = []
            for i in range(1, 51):
                for j in range(1, 51):
                    if find_parent(parent, i, j) == (r, c):
                        unmerge_list.append((i, j))
            for i, j in unmerge_list:
                parent[i][j] = (i, j)
                data[(i, j)] = ''
            data[(int(order[1]), int(order[2]))] = prev_data
        elif order[0] == 'PRINT':
            r, c = find_parent(parent, int(order[1]), int(order[2]))
            if data[(r, c)] == '':
                answer.append('EMPTY')
            else:
                answer.append(data[r, c])

    return answer


# commands = ["UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice",
#             "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta",
#             "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
#             "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"]
commands = ["UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1",
            "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"]
print(solution(commands=commands))
