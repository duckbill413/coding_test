# 1033 칵테일 만들기
N = int(input())
ratio = [[] for _ in range(N)]
visited = [False] * (N)
august14 = [0] * (N)
lcm = 1


def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)

def dfs(v):
    visited[v] = True
    for nv in ratio[v]:
        if not visited[nv[0]]:
            august14[nv[0]] = august14[v] * nv[2] // nv[1]
            dfs(nv[0])


for i in range(N - 1):
    a, b, p, q = map(int, input().split())
    ratio[a].append((b, p, q))
    ratio[b].append((a, q, p))
    lcm *= (p * q) // gcd(p, q)

august14[0] = lcm
dfs(0)

mgcd = august14[0]
for i in range(1, N):
    mgcd = gcd(mgcd, august14[i])

for i in range(N):
    print(august14[i] // mgcd, end=' ')