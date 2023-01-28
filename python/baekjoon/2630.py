# 2630 색종이 만들기
import sys

input = sys.stdin.readline

N = int(input())
table = []
for i in range(N):
    row = list(map(int, input().split()))
    table.append(row)

blue, white = 0, 0


def check(mini):
    root = mini[0][0]
    for i in range(len(mini)):
        for j in range(len(mini)):
            if mini[i][j] != root:
                return False
    return True


def make_color(mini):
    if check(mini):
        if mini[0][0] == 0:
            global white
            white += 1
        else:
            global blue
            blue += 1
        return
    else:
        new_size = len(mini) // 2
        table1 = []
        for i in range(new_size):
            table1.append(mini[i][:new_size])
        table2 = []
        for i in range(new_size):
            table2.append(mini[i][new_size:])
        table3 = []
        for i in range(new_size, new_size * 2):
            table3.append(mini[i][:new_size])
        table4 = []
        for i in range(new_size, new_size * 2):
            table4.append(mini[i][new_size:])

        make_color(table1)
        make_color(table2)
        make_color(table3)
        make_color(table4)


make_color(table)

print(white)
print(blue)
