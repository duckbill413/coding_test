A = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

word = input()

answer = 0

for a in A:
    while a in word:
        index = word.index(a)
        word = word[:index] + " " + word[index + len(a):]
        answer += 1

word = word.replace(" ", "")
print(answer + len(word))
