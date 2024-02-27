# 1411 비슷한 단어

import sys

input = sys.stdin.readline

N = int(input())
words = [list(input().strip()) for _ in range(N)]

answer = 0
for i in range(N - 1):
    for j in range(i+1, N):
        isOk = True
        alphabet = {}
        reverse_alpha = {}
        for k in range(len(words[j])):
            # 알파벳이 등록되어 있는 경우
            if words[i][k] in alphabet:
                # 알파벳이 등록된 것과 다른 경우 실패
                if alphabet[words[i][k]] != words[j][k]:
                    isOk = False
                    break
            else:
                # 해당 알파벳에 대해 이미 다른 알파벳이 등록되어 있는 경우
                if words[j][k] in reverse_alpha:
                    isOk = False
                    break
                alphabet[words[i][k]] = words[j][k]
                reverse_alpha[words[j][k]] = words[i][k]
        if isOk:
            answer += 1

print(answer)