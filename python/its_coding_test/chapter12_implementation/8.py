# 8. 문자열 재정열

s = input()

list = []
sum_num = 0

for i in s:
    if i.isalpha():
        list.append(i)
    else:
        sum_num += int(i)

list.sort()
if sum_num != 0:
    list.append(str(sum_num))
print(''.join(list))