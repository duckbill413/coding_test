def solution(people, limit):
    answer = 0
    people.sort()

    start = 0
    end = len(people) - 1

    while start < end:
        if people[start] > limit // 2:
            answer += end - start + 1
            break
        if people[start] + people[end] <= limit:
            start += 1
            end -= 1
        else:
            end -= 1
        answer += 1
    if start == end:
        answer += 1

    return answer
