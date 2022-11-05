# 20. 감시 피하기
import collections

n = int(input())
data = []
for i in range(n):
    data.append(list(map(str, input().split())))

school = [[] for i in range(n)]
teachers = []
for i in range(n):
    for j in range(n):
        if data[i][j] == 'X':
            school[i].append(0)
        elif data[i][j] == 'S':
            school[i].append(1)
        elif data[i][j] == 'T':
            school[i].append(2)
            teachers.append((i, j))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def find_student():
    for teacher in teachers:
        for i in range(4):
            nx = teacher[0] + dx[i]
            ny = teacher[1] + dy[i]

            while 0 <= nx < n and 0 <= ny < n:
                if school[nx][ny] == -1:
                    break
                if school[nx][ny] == 1:
                    return False
                nx += dx[i]
                ny += dy[i]
    return True


flag = False


def defence(count):
    if count == 3:
        result = find_student()
        if result:
            global flag
            flag = True
        return
    else:
        for i in range(n):
            for j in range(n):
                if school[i][j] == 0:
                    school[i][j] = -1
                    defence(count + 1)
                    school[i][j] = 0


defence(0)
if flag:
    print('YES')
else:
    print('NO')

'''
5
X S X X T
T X S X X
X X X X X
X T X X X
X X T X X

4
S S S T
X X X X
X X X X
T T T X
'''
