def solution(s, n):
    answer = list(s)
    for i in range(len(answer)):
        if 'A' <= answer[i] <= 'Z':
            tmp = ord(answer[i]) + n
            answer[i] = chr(tmp) if tmp <= ord('Z') else chr(tmp - ord('Z') + ord('A') - 1)
        elif 'a' <= answer[i] <= 'z':
            tmp = ord(answer[i]) + n
            answer[i] = chr(tmp) if tmp <= ord('z') else chr(tmp - ord('z') + ord('a') - 1)
    return ''.join(answer)
