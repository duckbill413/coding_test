# 순차 탐색 소스 코드
def sequential_search(n, target, array):
    # 각 원소를 하나씩 확인하며
    for i in range(n):
        # 현재의 원소가 찾고자하는 원소와 동일한 경우
        if array[i] == target:
            return i+1

input_data = input().split()
n = int(input_data[0]) # 원소의 개수
target = input_data[1] # 찾을 문자열

array = input().split()

print(sequential_search(n, target, array))
