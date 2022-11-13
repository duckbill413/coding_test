# 30. 가사 검색
import bisect

array = [[] for _ in range(100001)]
reversed_array = [[] for _ in range(100001)]


def count_by_range(array, left_value, right_value):
    right_index = bisect.bisect_right(array, right_value)
    left_index = bisect.bisect_left(array, left_value)
    return right_index - left_index


def solution(words, queries):
    answer = []
    for word in words:
        array[len(word)].append(word)
        reversed_array[len(word)].append(word[::-1])

    for i in range(100001):
        array[i].sort()
        reversed_array[i].sort()

    for query in queries:
        if query[0] == '?':
            count = count_by_range(reversed_array[len(query)], query[::-1].replace('?', 'a'),
                                   query[::-1].replace('?', 'z'))
        else:
            count = count_by_range(array[len(query)], query.replace('?', 'a'), query.replace('?', 'z'))
        answer.append(count)
    return answer
