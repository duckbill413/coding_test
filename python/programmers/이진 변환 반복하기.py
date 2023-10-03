def solution(s):
    count = 0
    zero = 0

    while s != "1":
        count += 1
        length = 0
        for i in range(len(s)):
            if s[i] == "0":
                zero += 1
            else:
                length += 1
        s = bin(length)[2:]
    return [count, zero]


print(solution("110010101001"))