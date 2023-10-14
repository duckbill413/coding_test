# 2018 KAKAO BLIND RECRUITMENT [3차] 파일명 정렬

def solution(files):
    f = []
    for file in files:
        flag = False
        idx = 0
        for i in range(len(file)):
            if not flag and ('0' <= file[i] <= '9'):
                idx = i
                flag = True
            elif flag and (file[i] < '0' or file[i] > '9'):
                f.append([file[:idx], file[idx:i], file[i:]])
                break
            if i == len(file) - 1: # 데이터가 숫자로 끝나 tail 부분이 없는 경우
                f.append([file[:idx], file[idx:i+1], ''])
    f.sort(key = lambda x: (x[0].lower(), int(x[1])))

    answer = []
    for s in f:
        answer.append(''.join(s))

    return answer