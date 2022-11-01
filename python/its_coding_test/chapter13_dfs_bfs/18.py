# 18. 괄호 변환

def balance(p):
    count = 0
    for i in range(len(p)):
        if p[i] == '(':
            count += 1
        else:
            count -= 1
        if count == 0:
            return i # 균형 잡힌 문자열의 index

def correct(p):
    count = 0
    for i in p:
        if i == '(':
            count += 1
        else:
            if count == 0:
                return False
            count -= 1
    return True


def solution(p):
    if len(p) == 0:
        return p
    index = balance(p)

    u = p[:index+1]
    v = p[index+1:]

    answer = ''
    if correct(u):
        answer = u + solution(v)
    else:
        answer = '('
        answer += solution(v)
        answer += ')'

        u = list(u[1:-1])
        for i in u:
            if i == '(':
                answer += ')'
            else:
                answer += '('
    return answer

p = '()))((()'
print(solution(p))