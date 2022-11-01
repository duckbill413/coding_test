# 19. 연산자 끼워 넣기
import itertools
''''
Python itertools
1) combinations: 조합을 표현할 때 사용되는 메소드. 한 리스트에서 중복을 허용하지 않고 모든 경우의 수를 구하는 것이다. n! / r! / (n-r)!
2) permutations: 순열을 표현할 때 사용되는 메소드이다 한 리스트에서 중복을 허용하고 모든 경우의 수를 구하는 것이다. n! / r!
3) product: 데카르트 곱이라고하는 casrtesian product를 표현할 때 사용하는 메소드이다.(DB의 join, 관계대수의 product 개념)
'''
n = int(input())
num = list(map(int, input().split()))
action = list(map(int, input().split()))

operations = []
operation = ['+', '-', '*', '/']
for i in range(len(action)):
    for j in range(action[i]):
        operations.append(operation[i])

commands = list(itertools.permutations(operations))

max_answer = -int(1e10)
min_answer = int(1e10)
for command in commands:
    answer = num[0]
    for oper, number in zip(command, num[1:]):
        if oper == '+':
            answer += number
        elif oper == '-':
            answer -= number
        elif oper == '*':
            answer *= number
        elif oper == '/':
            answer = int(answer / number)
    max_answer = max(max_answer, answer)
    min_answer = min(min_answer, answer)

print(int(max_answer))
print(int(min_answer))


'''
2
5 6
0 0 1 0

3
3 4 5
1 0 1 0

6
1 2 3 4 5 6
2 1 1 1
'''