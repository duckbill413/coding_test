def solution(a, b):
    m = [0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    w = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
    day = 0

    for i in range(a):
        day += m[i]

    day += b + 5

    day = day % 7

    return w[day - 1]
