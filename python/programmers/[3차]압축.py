# [3차] 압축
def solution(msg):
    answer = []

    d = {}
    for i in range(ord('A'), ord('Z')+1):
        d[str(chr(i))] = i - ord('A') + 1

    word = ""
    num = 27

    for m in msg:
        if word+str(m) in d:
            word += str(m)
        else:
            answer.append(d[word])
            d[word+str(m)] = num
            num+=1
            word = str(m)
    answer.append(d[word])

    return answer

print(solution("KAKAO"))