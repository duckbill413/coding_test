# 7. 럭키 스트레이트

n = input()
length = len(n)

left = n[:length//2]
right = n[length//2:]

sum_left = sum_right = 0
for i in range(length//2):
    sum_left += int(left[i])
    sum_right += int(right[i])

if sum_left == sum_right:
    print('LUCKY')
else:
    print('READY')