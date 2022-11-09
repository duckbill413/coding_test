# 25. 실패율

def solution(N, stages):
    answer = []
    peoples = len(stages)
    for i in range(1, N+1):
        count = stages.count(i)

        if peoples == 0:
            fail = 0
        else:
            fail = count / peoples

        answer.append((fail, i))
        peoples -= count

    answer.sort(key = lambda x:(-x[0], x[1]))
    answer = [x[1] for x in answer]

    print(answer)
    return answer

N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
# stages = [4, 4, 4, 4, 4]
solution(N, stages)