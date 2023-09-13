# 키패드 누르기

def solution(numbers, hand):
    answer = ''
    location = {}
    for i in range(12):
        location[i + 1] = (i // 3, i % 3)
    pl, pr = location[10], location[12]

    for number in numbers:
        if number in {1, 4, 7}:
            pl = location[number]
            answer += 'L'
        elif number in {3, 6, 9}:
            pr = location[number]
            answer += 'R'
        else:
            number = 11 if number == 0 else number
            number_position = location[number]
            dl = abs(number_position[0] - pl[0]) + abs(number_position[1] - pl[1])
            dr = abs(number_position[0] - pr[0]) + abs(number_position[1] - pr[1])
            if dl > dr:
                pr = number_position
                answer += 'R'
            elif dl < dr:
                pl = number_position
                answer += 'L'
            else:
                if hand == 'left':
                    pl = number_position
                    answer += 'L'
                else:
                    pr = number_position
                    answer += 'R'

    return answer
