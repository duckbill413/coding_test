word = input()
s = 0
e = len(word) - 1

answer = 1
while s <= e:
    if word[s] != word[e]:
        answer = 0
        break
    s += 1
    e -= 1
print(answer)