s = input()
answer = 0
for i in range(len(s)):
    if s[i] < 'P':
        answer += 3 + (ord(s[i]) - ord('A')) // 3
    elif 'P' <= s[i] <= 'S':
        answer += 8
    elif 'T' <= s[i] <= 'V':
        answer += 9
    elif 'W' <= s[i] <= 'Z':
        answer += 10
print(answer)