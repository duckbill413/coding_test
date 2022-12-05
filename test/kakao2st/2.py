import itertools

def solution(n, edges, users, d, limit):
    INF = int(1e9)
    length = len(users) + 1
    distance = [[INF] * length for _ in range(length)]

    for i in range(length):
        distance[i][i] = 0

    for edge in edges:
        s, e, cost = edge
        distance[s][e] = cost
        distance[e][s] = cost

    for k in range(1, length):
        for a in range(1, length):
            for b in range(1, length):
                distance[a][b] = min(distance[a][b], distance[a][k] + distance[k][b])

    for i in range(1, length):
        print(distance[i][1:])

    answer = 0
    combinations = list(itertools.combinations(range(1, length), 2))
    combi_len = len(combinations)
    for i in range(combi_len):
        combinations.append((combinations[i][1], combinations[i][0]))
    print(combinations)

    for combi in combinations:
        station1, station2 = combi
        slot = [0] * length
        copy_users = [0] * length
        for i in range(1, length):
            copy_users[i] = users[i-1]

        for i in range(1, length):
            if distance[station1][i] <= d and slot[station1] < limit:
                if slot[station1] + copy_users[i] > limit:
                    copy_users[i] -= (limit - slot[station1])
                    slot[station1] = limit
                    break
                else:
                    slot[station1] += copy_users[i]
                    copy_users[i] = 0

        for i in range(1, length):
            if distance[station2][i] <= d and slot[station2] < limit:
                if slot[station2] + copy_users[i] > limit:
                    copy_users[i] -= (limit - slot[station2])
                    slot[station2] = limit
                    break
                else:
                    slot[station1] += copy_users[i]
                    copy_users[i] = 0

        result = slot[station1] + slot[station2]
        answer = max(result, answer)

    print(answer)
    return answer


n = 7
edges = [[1, 2, 2], [5, 2, 2], [1, 5, 2], [1, 3, 1], [1, 6, 2], [1, 7, 3], [6, 7, 4], [7, 4, 1]]
users = [0, 2, 0, 0, 0, 4, 1]
d = 2
limit = 3
solution(n, edges, users, d, limit)

'''
테스트 1
입력값 〉
7, [[1, 2, 2], [5, 2, 2], [1, 5, 2], [1, 3, 1], [1, 6, 2], [1, 7, 3], [6, 7, 4], [7, 4, 1]], [0, 2, 0, 0, 0, 4, 1], 2, 3
기댓값 〉
6
실행 결과 〉
테스트를 통과하였습니다.
출력 〉
[0, 2, 1, 4, 2, 2, 3]
[2, 0, 3, 6, 2, 4, 5]
[1, 3, 0, 5, 3, 3, 4]
[4, 6, 5, 0, 6, 5, 1]
[2, 2, 3, 6, 0, 4, 5]
[2, 4, 3, 5, 4, 0, 4]
[3, 5, 4, 1, 5, 4, 0]
[(1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7), (2, 3), (2, 4), (2, 5), (2, 6), (2, 7), (3, 4), (3, 5), (3, 6), (3, 7), (4, 5), (4, 6), (4, 7), (5, 6), (5, 7), (6, 7), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (3, 2), (4, 2), (5, 2), (6, 2), (7, 2), (4, 3), (5, 3), (6, 3), (7, 3), (5, 4), (6, 4), (7, 4), (6, 5), (7, 5), (7, 6)]
6
테스트 2
입력값 〉
3, [[1, 2, 1], [3, 2, 1]], [1, 2, 1], 1, 2
기댓값 〉
4
실행 결과 〉
테스트를 통과하였습니다.
출력 〉
[0, 1, 2]
[1, 0, 1]
[2, 1, 0]
[(1, 2), (1, 3), (2, 3), (2, 1), (3, 1), (3, 2)]
4
테스트 3
입력값 〉
3, [[1, 2, 2], [3, 2, 2]], [1, 2, 1], 1, 2
기댓값 〉
3
실행 결과 〉
테스트를 통과하였습니다.
출력 〉
[0, 2, 4]
[2, 0, 2]
[4, 2, 0]
[(1, 2), (1, 3), (2, 3), (2, 1), (3, 1), (3, 2)]
3
테스트 4
입력값 〉
6, [[1, 2, 1], [2, 3, 1], [3, 6, 1], [6, 5, 1], [4, 5, 1], [4, 1, 1]], [1, 1, 1, 1, 1, 1], 1, 3
기댓값 〉
6
실행 결과 〉
테스트를 통과하였습니다.
출력 〉
[0, 1, 2, 1, 2, 3]
[1, 0, 1, 2, 3, 2]
[2, 1, 0, 3, 2, 1]
[1, 2, 3, 0, 1, 2]
[2, 3, 2, 1, 0, 1]
[3, 2, 1, 2, 1, 0]
[(1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (2, 3), (2, 4), (2, 5), (2, 6), (3, 4), (3, 5), (3, 6), (4, 5), (4, 6), (5, 6), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (3, 2), (4, 2), (5, 2), (6, 2), (4, 3), (5, 3), (6, 3), (5, 4), (6, 4), (6, 5)]
6
'''