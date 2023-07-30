# 21315 카드 섞기
import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

MAX_K = -1
tmp = 1
while tmp <= N:
    tmp <<= 1
    MAX_K += 1


def shuffle(cards, K):
    count = 1
    prev = []
    while count <= K + 1:
        if count == 1:
            index = N - pow(2, K)
            prev = cards[index:]
            cards = prev + cards[:index]
        else:
            index = len(prev) - pow(2, K - count + 1)
            prev = prev[index:]
            cards = prev + cards[:index] + cards[index * 2:]
        count += 1
    return cards


for first in range(1, MAX_K + 1):
    for second in range(1, MAX_K + 1):
        a = shuffle([i for i in range(1, N + 1)], first)
        b = shuffle(a, second)
        if b == A:
            print(first, second)
            exit()
