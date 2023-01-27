# 2018 연속된 자연수의 합 구하기
# 투 포인터

N = int(input())
count = 1
start_index = 1
end_index = 1
sum = 1

while end_index != N:
    if sum == N:
        count += 1
        end_index += 1
        sum += end_index
    elif sum < N:
        end_index += 1
        sum += end_index
    else:
        sum -= start_index
        start_index += 1

print(count)