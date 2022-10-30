# 14. 외벽 점검
# 원형을 일자로 만들면 편리하다
import itertools


def solution(n, weak, dist):
    length = len(weak)
    for i in range(length):
        weak.append(weak[i] + n)

    answer = len(dist) + 1
    # 0 부터 length -1 까지의 위치를 시작점으로 설정
    for start in range(length):
        for friends in list(itertools.permutations(dist)):
            count = 1
            position = weak[start] + friends[count-1] # 탐색 범위
            for index in range(start, start+length):
                if position < weak[index]:
                    count += 1
                    if count > len(dist):
                        break
                    position = weak[index] + friends[count -1]
            answer = min(answer, count)
    if answer == len(dist) + 1:
        return -1
    return answer