# 2042 구간 합 구하기 3
# 세그먼트 트리 - 구간 합
import sys
input = sys.stdin.readline

N, M, K = map(int, input().split())

length = 1
treeHeight = 0
while length < N:
    length *= 2
    treeHeight += 1

treeSize = pow(2, treeHeight + 1)
leftNodeStartIndex = treeSize // 2
tree = [0] * treeSize

# 데이터를 리프 노드에 저장
for i in range(leftNodeStartIndex, leftNodeStartIndex + N):
    tree[i] = int(input())


# 인덱스 트리 생성 함수
def setTree(i):
    while i != 1:
        tree[i // 2] += tree[i]
        i -= 1


setTree(treeSize - 1)


# 값 변경 함수
def changeVal(index, value):
    diff = value - tree[index]
    while index > 0:
        tree[index] += diff
        index //= 2


# 구간 합 계산 함수
def getSum(s, e):
    partSum = 0
    while s <= e:
        if s % 2 == 1:
            partSum += tree[s]
            s += 1
        if e % 2 == 0:
            partSum += tree[e]
            e -= 1
        s //= 2
        e //= 2
    return partSum


for _ in range(M + K):
    q, s, e = map(int, input().split())
    if q == 1:
        changeVal(s + leftNodeStartIndex - 1, e)
    elif q == 2:
        s = s + leftNodeStartIndex - 1
        e = e + leftNodeStartIndex - 1
        print(getSum(s, e))
