def convert(time):
    return int(time[0:2]) * 60 + int(time[3:])


def solution(book_time):
    times = sorted([(convert(time[0]), convert(time[1]) + 10) for time in book_time])

    rooms = []
    for time in times:
        if not rooms:
            rooms.append(time)
            continue

        for idx, room in enumerate(rooms):
            if time[0] >= room[-1]:
                rooms[idx] = time
                break
        else:
            rooms.append(time)

    return len(rooms)
