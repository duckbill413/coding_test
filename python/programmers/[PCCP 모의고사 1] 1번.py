import collections

def solution(input_string):
    d = collections.defaultdict(int)

    for n in input_string:
        d[n] += 1

    answer = set()

    i = 0
    while i < len(input_string):
        pivot = input_string[i]
        if pivot in answer or d[pivot] == 1:
            i += 1
            continue
        count = 0
        for j in range(i, len(input_string)):
            if pivot == input_string[j]:
                count += 1
                i = j
            else:
                i = j - 1
                break

        if d[pivot] != count:
            answer.add(pivot)
        i += 1

    answer = list(answer)
    answer.sort()
    return ''.join(answer) if len(answer) > 0 else 'N'


# input_string = "eeee"
input_string = "edeaaabbccd"
print(solution(input_string))