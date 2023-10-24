# 월간 코드 챌린지 1 ) 쿼드압축 후 개수 세기

def solution(arr):
    answer = [0, 0]

    N = len(arr)

    def dfs(x, y, size):
        nonlocal answer
        if size == 1:
            answer[arr[x][y]] += 1
            return

        isOk = True
        root = arr[x][y]
        for i in range(x, x + size):
            for j in range(y, y + size):
                if root != arr[i][j]:
                    isOk = False
                    break
            if not isOk:
                break

        if isOk:
            answer[root] += 1
        else:
            half = size // 2
            dfs(x, y, half)
            dfs(x + half, y, half)
            dfs(x, y + half, half)
            dfs(x + half, y + half, half)

    dfs(0, 0, N)

    return answer
