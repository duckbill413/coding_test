# 17298 오큰수 구하기
N = int(input())
numbers = list(map(int, input().split()))

answer = [0] * N
stack = []

for i in range(N):
    # 스택이 비어 있지 않고 현재 수열이 스택 top 인덱스가 가리키는 수열보다 큰 경우
    while stack and numbers[stack[-1]] < numbers[i]:
        answer[stack.pop()] = numbers[i]
    stack.append(i)

while stack:
    answer[stack.pop()] = -1

print(*answer, end=' ')