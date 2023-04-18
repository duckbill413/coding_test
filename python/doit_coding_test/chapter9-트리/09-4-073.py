# 11505 구간 곱 구하기
import sys

input = sys.stdin.readline
MOD = 1000000007
N, M, K = map(int, input().split())

treeHeight = 0
length = 1
while length < N:
    length *= 2
    treeHeight += 1

treeSize = 2 ** (treeHeight + 1)
tree = [1] * treeSize

leftStartIndex = treeSize // 2
for i in range(leftStartIndex, leftStartIndex + N):
    tree[i] = int(input())


def setTree(i):
    while i != 1:
        tree[i // 2] = tree[i // 2] * tree[i] % MOD
        i -= 1


setTree(treeSize - 1)


def changeValue(index, value):
    tree[index] = value
    while index > 1:
        index //= 2
        tree[index] = tree[index * 2] % MOD * tree[index * 2 + 1] % MOD


def getMulti(s, e):
    partMulti = 1
    while s <= e:
        if s % 2 == 1:
            partMulti = partMulti * tree[s] % MOD
            s += 1
        if e % 2 == 0:
            partMulti = partMulti * tree[e] % MOD
            e -= 1
        s //= 2
        e //= 2
    return partMulti


for _ in range(M + K):
    a, b, c = map(int, input().split())
    if a == 1:
        changeValue(b + leftStartIndex - 1, c)
    elif a == 2:
        s = b + leftStartIndex - 1
        e = c + leftStartIndex - 1
        print(getMulti(s, e))
