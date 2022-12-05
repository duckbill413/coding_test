def get_next(start, time):
    day = 0
    for i in range(5, 1, -1):
        start[i] += time[i - 2]
        if i == 2:
            day += time[i - 2]

    if start[5] >= 60:  # ss
        start[4] += 1
        start[5] -= 60

    if start[4] >= 60:  # mm
        start[3] += 1
        start[4] -= 60

    if start[3] >= 24:  # hh
        start[2] += 1
        start[3] -= 24
        day += 1

    if start[2] >= 31:  # DD
        DD = start[2] // 30
        start[1] += DD
        start[2] -= DD * 30

    if start[1] >= 13:  # MM
        MM = start[1] // 12
        start[0] += MM
        start[1] -= MM * 12

    return day


def solution(s, times):
    start_time = list(map(int, s.split(":")))
    day = 1
    success = 1

    for time in times:
        time = list(map(int, time.split(":")))
        result = get_next(start_time, time)
        day += result
        if result > 1:
            success = 0

    return [success, day]


# Case 1
s = "2021:04:12:16:08:35"
times = ["01:06:30:00", "01:04:12:00"]
# Case 2
s = "2021:04:12:16:08:35"
times = ["01:06:30:00", "00:01:12:00"]
# Case3
s = "2021:04:12:16:10:42"
times = ["01:06:30:00"]
# Case4
s = "2021:04:12:16:08:35"
times = ["01:06:30:00", "01:01:12:00", "00:00:09:25"]
# Case5
s = "2021:11:20:17:10:20"
times = ["45:07:10:40"]
print(solution(s, times))
