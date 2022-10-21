# 10. 자물쇠와 열쇠
# 이차원 배열의 회전 이용

# 90도 회전
import copy


def rotate_90(key):
    row = len(key)
    col = len(key[0])
    new = [[0] * row for i in range(col)]

    for i in range(row):
        for j in range(col):
            new[j][row - i - 1] = key[i][j]
    return new


# 180도 회전
def rotate_180(key):
    row = len(key)
    col = len(key[0])
    new = [[0] * row for i in range(col)]

    for i in range(row):
        for j in range(col):
            new[col - i - 1][row - j - 1] = key[i][j]
    return new


# 270 회전
def rotate_270(key):
    row = len(key)
    col = len(key[0])
    new = [[0] * row for i in range(col)]

    for i in range(row):
        for j in range(col):
            new[col - j - 1][i] = key[i][j]
    return new


# 회전을 담당
def rotate(key, select):
    if select == 0:
        return copy.deepcopy(key)
    elif select == 1:
        return rotate_90(key)
    elif select == 2:
        return rotate_180(key)
    elif select == 3:
        return rotate_270(key)


# 중앙 부분만 탐색
def check(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    return True


def solution(key, lock):
    key_len = len(key)
    lock_len = len(lock)

    new_lock = [[0] * (lock_len * 3) for _ in range(lock_len*3)]  # 기존의 자물쇠 보다 3배 큰 사이즈의 자물쇠 생성
    for i in range(lock_len):
        for j in range(lock_len):
            new_lock[lock_len + i][lock_len + j] = lock[i][j]

    # 열쇠를 회전 및 이동시키며 확인
    for k in range(4):
        new_key = rotate(key, k)
        for x in range(1, lock_len * 2):
            for y in range(1, lock_len * 2):
                # 자물쇠에 열쇠를 넣기
                for i in range(key_len):
                    for j in range(key_len):
                        new_lock[x+i][y+j] += new_key[i][j]
                # 자물쇠가 맞는지 확인
                if check(new_lock):
                    return True
                for i in range(key_len):
                    for j in range(key_len):
                        new_lock[x+i][y+j] -= new_key[i][j]

    return False


key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
print(solution(key, lock))