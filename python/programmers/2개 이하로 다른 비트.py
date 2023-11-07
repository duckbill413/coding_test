def solution(numbers):
    answer = []

    for num in numbers:
        tmp = num
        cnt = 0
        while num % 2 == 1:
            cnt += 1
            num //= 2
        answer.append(tmp + 2 ** (cnt - 1) if cnt != 0 else tmp + 1)
    return answer
