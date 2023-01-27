# 1940 주몽의 명령
# 투 포인터
N = int(input())
M = int(input())
materials = list(map(int, input().split()))
materials.sort()

count = 0
start_index = 0
end_index = N-1

while start_index != end_index:
    sum = materials[start_index] + materials[end_index]
    if sum == M:
        count += 1
        start_index += 1
        end_index -= 1
    elif sum > M:
        end_index -= 1
    else:
        start_index += 1

print(count)