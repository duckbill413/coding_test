# 2251 물의 양 구하기
import collections

sender = [0, 0, 1, 1, 2, 2]
receiver = [1, 2, 0, 2, 0, 1]
now = list(map(int, input().split()))  # 물통의 부피 (변화 없음)
visited = [[False for j in range(201)] for i in range(201)]
answer = [False] * 201


def bfs():
    q = collections.deque()
    q.append((0, 0))  # A, B 초기 무게
    visited[0][0] = True
    answer[now[2]] = True

    while q:
        cur = q.popleft()
        A = cur[0]  # A 현재 무게
        B = cur[1]  # B 현재 무게
        C = now[2] - A - B  # A, B를 통해 얻는 C 무게

        for k in range(6):
            next = [A, B, C]  # 물의 이동에 따라 변화 하는 무게
            next[receiver[k]] += next[sender[k]]
            next[sender[k]] = 0

            if next[receiver[k]] > now[receiver[k]]:  # 물이 넘칠 때
                # 초과하는 만큼 다시 이전 물통에 넣어 주기
                next[sender[k]] = next[receiver[k]] - now[receiver[k]]
                next[receiver[k]] = now[receiver[k]]  # 대상 물통 최대로 채우기

            # A, B, C 무게가 동일한 노드에 방문한 이력이 있는 경우 큐에 추가 X
            if not visited[next[0]][next[1]]:
                visited[next[0]][next[1]] = True
                q.append((next[0], next[1]))
                if next[0] == 0:
                    answer[next[2]] = True


bfs()

for i in range(201):
    if answer[i]:
        print(i, end=' ')
