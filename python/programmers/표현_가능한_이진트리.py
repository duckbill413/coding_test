# 표현 가능한 이진트리
# TODO
def check(number):
    length = len(number)
    if length == 1 or '1' not in number or '0' not in number:
        return True

    mid = length // 2
    if number[mid] == '0':
        return False

    return check(number[:mid]) & check(number[mid + 1:])


def solution(numbers):
    answer = []
    # 포화 이진 트리의 크기는 2 ** N - 1 개의 크기를 가진다.
    bin_list = [2 ** x - 1 for x in range(50)]
    for number in numbers:
        number = format(number, 'b')
        length = len(number)
        for num in bin_list:
            if num >= length:
                number = '0' * (num - length) + number
                break
        answer.append(1 if check(number) else 0)
    return answer


print(solution([63, 111, 95]))
