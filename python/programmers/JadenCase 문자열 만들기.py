def solution(s):
    s = s.split(' ')
    for index, word in enumerate(s):
        s[index] = word[:1].upper() + word[1:].lower()
    return ' '.join(s)
