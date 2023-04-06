# 형 변환 Casting

# 데이터를 다른 자료형으로 형 변환
print(float(3)) # 실수형으로 바꿈
print(int(3.0)) # 정수형으로 바꿈
print(3) # 문자열로 바꿈

# 다른 진수로 변환
print(hex(12)) # 16진수로 변환
print(oct(10)) # 8진수로 변환
print(bin(10)) # 2진수로 변환

# 10진수로 바꿀 때는 자동으로 바뀜
a = 0b0010
print(a)

# 다른 진수값이 문자열이면 int() 함수 사용
print(int('0xc', 16))
print(int('0o14', 8))
print(int('0b1100', 2))

# 두 번째 인자에 입력 값의 진수를 명시하면 됨. 다른 벡터로의 변환도 가능
print(tuple([1, 2])) # 리스트 to 튜플
print(list((1, 2))) # 튜플 to 리스트
print(set([1, 2])) # 리스트를 집합 데이터형으로 변환

# 딕셔너리 캐스팅은 key, value가 한 쌍으로 된 경우 가능
print(dict([[1, 2], [3, 4]]))