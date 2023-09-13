# 2018 KAKAO BLIND RECRUITMENT
# [3차] n진수 게임

def convert(num, n):
    word = []
    while num:
        word.append(num % n)
        num //= n
    if len(word) == 0:
        word.append(0)
    return list(reversed(word))

def solution(n, t, m, p):
    answer = ''

    count = 0
    order = 0
    while True:
        number = convert(count, n)
        for num in number:
            # 튜브가 말할 차례
            if order % m == p - 1:
                if num >= 10:
                    answer += str(chr(ord('A') + num - 10))
                else:
                    answer += str(num)
            order += 1
            if len(answer) == t:
                return answer
        count += 1


print(solution(16, 16, 2, 2))