# 한 줄 입력받아 출력하는 소스코드
import sys
# 하나의 문자열 데이터 입력받기
# 한줄 입력 받고 .rstrip() 를 꼭 사용해야 한다.
input_data = sys.stdin.readline().rstrip()
list = input_data.split() # 입력 데이터를 나누어 리스트로 변환

# 입력받은 문자열 그대로 출력
print(input_data)
print(list)