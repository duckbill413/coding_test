# 둘만의 암호
def solution(s, skip, index):
    answer = ''
    skip = set(skip)

    for w in s:
        count = 0
        while count != index:
            w = chr(ord(w) + 1) if ord(w) + 1 <= ord('z') else 'a'
            if w not in skip:
                count += 1
        answer += w
    return answer
