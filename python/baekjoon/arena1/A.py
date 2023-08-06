# A 양말 짝 맞추기
import collections
import sys

input = sys.stdin.readline

pair = collections.defaultdict(bool)

for i in range(5):
    num = int(input().strip())
    if pair[num] == False:
        pair[num] = True
    else:
        pair[num] = False

for key in pair.keys():
    if pair[key] == True:
        print(key)
        break