params = {
    "code": 0, "date": 1, "maximum": 2, "remain": 3
}


def solution(data: list, ext, val_ext, sort_by):
    answer = []

    for d in data:
        if d[params[ext]] < val_ext:
            answer.append(d)

    answer.sort(key=lambda x : x[params[sort_by]])
    return answer


data = [[1, 20300104, 100, 80], [2, 20300804, 847, 37], [3, 20300401, 10, 8]]
ext = "date"
val_ext = 20300501
sort_by = "remain"

print(solution(data, ext, val_ext, sort_by))
