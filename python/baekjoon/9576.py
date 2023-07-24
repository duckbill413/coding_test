# 9576 책 나눠주기
import sys

input = sys.stdin.readline

T = int(input())

for test_case in range(T):
    N, M = map(int, input().split())
    give = [list(map(int, input().split())) for _ in range(M)]

    give.sort(key=lambda x: x[1])

    books = [False] * (N+1)

    answer = 0
    for s, e in give:
        for i in range(s, e+1):
            if not books[i]:
                books[i] = True
                answer += 1
                break
    print(answer)