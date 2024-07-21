import heapq


def get_minutes(start, end):
    start_time = list(map(int, start.split(":")))
    end_time = list(map(int, end.split(":")))
    return end_time[0] * 60 + end_time[1] - start_time[0] * 60 - start_time[1]


def solution(m, musicinfos):
    m = m.replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#', 'L').replace('B#',
                                                                                                                 'M')
    q = []
    for musicinfo in musicinfos:
        start, end, title, music = map(str, musicinfo.split(","))
        minute = get_minutes(start, end)

        music = music.replace('A#', 'H').replace('C#', 'I').replace('D#', 'J').replace('F#', 'K').replace('G#',
                                                                                                          'L').replace(
            'B#', 'M')
        music = music * (minute // len(music)) + music[0: (minute % len(music))]
        if m in music:
            heapq.heappush(q, (-minute, start, title))

    return heapq.heappop(q)[2] if len(q) != 0 else '(None)'
