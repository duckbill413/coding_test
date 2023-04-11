# 1068 리프 노드의 개수 구하기
import sys

sys.setrecursionlimit(10 ** 8)

input = sys.stdin.readline

N = int(input())
root = 0

graph = [[] for _ in range(N)]

tree = list(map(int, input().split()))
for i in range(N):
    if tree[i] == -1:
        root = i
        continue
    graph[tree[i]].append(i)

del_node = int(input())

answer = 0

def dfs(start):
    global answer
    cNode = 0
    for next in graph[start]:
        if next == del_node:
            continue
        cNode += 1
        dfs(next)
    if cNode == 0:
        answer += 1


dfs(root)

if del_node == root:
    print(0)
else:
    print(answer)
