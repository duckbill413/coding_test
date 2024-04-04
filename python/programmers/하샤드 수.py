def solution(x):
    s = 0
    for i in list(str(x)):
        s += int(i)

    return x % s == 0