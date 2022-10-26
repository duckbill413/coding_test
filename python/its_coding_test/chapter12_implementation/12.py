# 12. 기둥과 보 설치
import sys

def possible(answer):
    for x, y, a in answer:
        if a == 0:  # 기둥
            if y == 0 or [x - 1, y, 1] in answer or [x, y - 1, 0] in answer or [x, y, 1] in answer:
                continue
            return False
        elif a == 1:  # 보
            if [x, y - 1, 0] in answer or [x + 1, y - 1, 0] in answer or \
                    ([x - 1, y, 1] in answer and [x + 1, y, 1] in answer):
                continue
            return False
    return True


def solution(n, build_frame):
    answer = []
    for frame in build_frame:
        x, y, a, b = frame
        if b == 0:  # 삭제하는 경우
            answer.remove([x, y, a])
            if not possible(answer):
                answer.append([x, y, a])
        elif b == 1:
            answer.append([x, y, a])
            if not possible(answer):
                answer.remove([x, y, a])

    return sorted(answer)


# input = sys.stdin.readline
# n = int(input())
# build_frame = []
# for i in range(n):
#     x, y, a, b = map(int, input().split())
#     build_frame.append([x, y, a, b])
n = 5
build_frame = [[1, 0, 0, 1],
               [1, 1, 1, 1],
               [2, 1, 0, 1],
               [2, 2, 1, 1],
               [5, 0, 0, 1],
               [5, 1, 0, 1],
               [4, 2, 1, 1],
               [3, 2, 1, 1]]

answer = solution(n, build_frame)
print(answer)
# key와 lamda를 이용하여 여러가지 기준으로 정렬하기
# print(sorted(answer, key=lambda x:(x[1], -x[0], -x[2])))


'''
5
1 0 0 1
1 1 1 1 
2 1 0 1
2 2 1 1
5 0 0 1
5 1 0 1
4 2 1 1
3 2 1 1
'''