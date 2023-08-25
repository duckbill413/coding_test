N = int(input())

answer = 0
for _ in range(N):
    alpha = [False] * 28
    word = input()

    find = True
    for i in range(len(word)):
        id = ord(word[i]) - ord('a')
        if not alpha[id] or word[i] == word[i - 1]:
            alpha[id] = True
        else:
            find = False
            break
    if find: answer += 1

print(answer)
