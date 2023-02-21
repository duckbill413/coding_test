# 1747 소수&팰린드롬 수 중에서 최솟값 찾기
import math

N = int(input())
MAX_SIZE = 10000001
A = [i for i in range(MAX_SIZE)]
A[1] = 0

for i in range(2, int(math.sqrt(MAX_SIZE)) + 1):
    if A[i] == 0:
        continue
    for j in range(i * 2, MAX_SIZE, i):
        A[j] = 0


def isPalindrome(target):
    temp = list(str(target))
    s = 0
    e = len(temp) - 1
    while s < e:
        if temp[s] != temp[e]:
            return False
        s += 1
        e -= 1
    return True


for i in range(N, MAX_SIZE):
    if A[i] != 0:
        num = A[i]
        if isPalindrome(num):
            print(num)
            break
