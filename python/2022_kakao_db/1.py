def solution(x, y, z):
    gap = y - x
    move = z + gap
    move = move // 2
    move = x + move
    if (abs(y - x) > z):
        return -1
    return move
