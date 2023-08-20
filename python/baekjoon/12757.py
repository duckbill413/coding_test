# 12757 전설의 JBNU
import bisect
import sys

input = sys.stdin.readline
print = sys.stdout.write

N, M, K = map(int, input().split())

keys = []
dic = {}


def findKey(key):
    if key in dic:
        return key
    index = bisect.bisect_left(keys, key)
    if index == 0:
        if abs(keys[index] - key) <= K:
            return keys[index]
    elif index == len(keys):
        if abs(keys[index - 1] - key) <= K:
            return keys[index - 1]
    else:
        left = key - keys[index - 1]
        right = keys[index] - key
        if left == right and left <= K:
            return -2
        elif left < right and left <= K:
            return keys[index - 1]
        elif left > right and right <= K:
            return keys[index]
    return -1


for _ in range(N):
    key, val = map(int, input().split())
    dic[key] = val
    bisect.insort_left(keys, key)

for _ in range(M):
    order = list(map(int, input().split()))
    if order[0] == 1:
        dic[order[1]] = order[2]
        bisect.insort_left(keys, order[1])
    elif order[0] == 2:
        key = findKey(order[1])
        if key >= 0:
            dic[key] = order[2]
    elif order[0] == 3:
        key = findKey(order[1])
        if key == -1:
            print(str(key) + "\n")
        elif key == -2:
            print("?\n")
        else:
            print(str(dic[key]) + "\n")
