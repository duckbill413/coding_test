import heapq


def get_minutes(start, end):
    start_time = list(map(int, start.split(":")))
    end_time = list(map(int, end.split(":")))
    return end_time[0] * 60 + end_time[1] - start_time[0] * 60 - start_time[1]


def melody_in_music(target, time, music):
    idx = 0
    time = 0

    while True:
    # 알파벳이 한글자 일 경우

    # 알파벳이 두글자 일 경우

    return False


def solution(m, musicinfos):
    q = []
    answer = ''

    for musicinfo in musicinfos:
        start, end, title, music = map(str, musicinfo.split(","))
        minute = get_minutes(start, end)
        r = melody_in_music(m, minute, music)
        print(r)

    return answer
