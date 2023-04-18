# 10868 최솟값 찾기2
# 세그먼트 트리 - 최솟값
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

length = 1
treeHeight = 0
while length < N:
    length <<= 1
    treeHeight += 1

treeSize = pow(2, treeHeight + 1)
leftNodeStartIndex = treeSize // 2
tree = [sys.maxsize] * treeSize

# 데이터를 리프 노드에 저장
for i in range(leftNodeStartIndex, leftNodeStartIndex + N):
    tree[i] = int(input())


# 인덱스 트리 생성 함수
def setTree(i):
    while i != 1:
        tree[i // 2] = min(tree[i], tree[i - 1])
        i -= 2


setTree(treeSize - 1)


# 최솟 값 찾기 함수
def getMin(s, e):
    partMin = sys.maxsize
    while s <= e:
        if s % 2 == 1:
            partMin = min(partMin, tree[s])
            s += 1
        if e % 2 == 0:
            partMin = min(partMin, tree[e])
            e -= 1
        s //= 2
        e //= 2
    return partMin


for _ in range(M):
    a, b = map(int, input().split())
    a = a + leftNodeStartIndex - 1
    b = b + leftNodeStartIndex - 1
    print(getMin(a, b))
