# 바탕화면 정리
def solution(wallpaper):
    sx, sy = 50, 50
    ex, ey = -1, -1

    N = len(wallpaper)
    M = len(wallpaper[0])

    for i in range(N):
        for j in range(M):
            if wallpaper[i][j] == '#':
                sx = min(sx, i)
                sy = min(sy, j)
                ex = max(ex, i)
                ey = max(ey, j)

    return [sx, sy, ex+1, ey+1]