import collections


def solution(str1, str2):
    answer = 0.0
    str1 = str1.lower()
    str2 = str2.lower()
    list1, list2 = [], []

    for i in range(len(str1) - 1):
        if str1[i].isalpha() and str1[i + 1].isalpha():
            list1.append(str1[i] + str1[i + 1])
    for i in range(len(str2) - 1):
        if str2[i].isalpha() and str2[i + 1].isalpha():
            list2.append(str2[i] + str2[i + 1])

    counter1 = collections.Counter(list1)
    counter2 = collections.Counter(list2)

    small = list((counter1 & counter2).elements())
    big = list((counter1 | counter2).elements())

    answer = len(small) / len(big) * 65536

    return int(answer)


str1 = 'FRANCE'
str2 = 'french'

print(solution(str1, str2))