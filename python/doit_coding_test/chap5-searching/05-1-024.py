# 2023 신기한 소수 찾기
# dfs
import sys

print = sys.stdout.write
N = int(input())

# 에라토스테네스의 체 <-- 해당 문제의 경우 메모리 초과
'''
M = 10 ** N - 1
A = [False, False] + [True] * (M - 1)  # 소수 판별 리스트
primes = []  # 소수의 리스트
for i in range(2, M + 1):
    if A[i]:
        primes.append(i)
        for j in range(2 * i, M + 1, i):
            A[j] = False
'''


def isPrime(num):
    for i in range(2, int(num / 2 + 1)):
        if num % i == 0:
            return False
    return True


def dfs(num):
    if len(str(num)) == N:
        print(str(num) + '\n')
    else:
        for i in range(1, 10):
            if i % 2 == 0:
                continue
            if isPrime(num * 10 + i):
                dfs(num * 10 + i)


dfs(2)
dfs(3)
dfs(5)
dfs(7)
