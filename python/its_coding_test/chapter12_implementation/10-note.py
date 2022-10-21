# 10. 자물쇠와 열쇠

# 회전을 담당 90도 회전
def rotate1(key): # 배열의 성질을 이용한 회전
    return [[row[i] for row in key[::-1]] for i in range(len(key[0]))]


def rotate2(key): # zip을 이용한 회전 변환시 list -> tuple의 형변환 발생
    return list(zip(*key[::-1]))



