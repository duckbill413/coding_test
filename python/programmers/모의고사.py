def solution(answers):
    students = [
        [1, 2, 3, 4, 5],
        [2, 1, 2, 3, 2, 4, 2, 5],
        [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    ]
    count = [0, 0, 0]

    for index, answer in enumerate(answers):
        for id, student in enumerate(students):
            if answer == student[index % len(student)]:
                count[id] += 1

    return [i + 1 for i, c in enumerate(count) if c == max(count)]
