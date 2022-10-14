# 3. 문자열 뒤집기

s = input()

group = [0, 0]
group[int(s[0])] += 1

flag = s[0]
for i in s:
    if int(i) != flag:
        flag = int(i)
        group[flag] += 1

print(min(group))