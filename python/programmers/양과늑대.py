import sys

sys.setrecursionlimit(10 ** 8)


def solution(info, edges):
    global answer
    visited = [0] * len(info)
    answer = 0
    def dfs(sheep, wolf):
        global answer
        if sheep > wolf:
            if sheep > answer:
                answer = sheep
        else:
            return

        for p, c in edges:
            if visited[p] and not visited[c]:
                visited[c] = 1
                if info[c] == 0:
                    dfs(sheep + 1, wolf)
                else:
                    dfs(sheep, wolf + 1)
                visited[c] = 0

    visited[0] = 1
    dfs(1, 0)

    return answer


info = [0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1]
edges = [[0, 1], [1, 2], [1, 4], [0, 8], [8, 7], [9, 10], [9, 11], [4, 3], [6, 5], [4, 6], [8, 9]]
answer = solution(info, edges)
print(answer)
