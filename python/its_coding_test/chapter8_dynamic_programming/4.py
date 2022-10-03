# 4. 바닥 공사

N = int(input())
delta = 796796
d = [0] * 1001
d[1] = 1
d[2] = 3

for i in range(3, N+1):
    d[i] = (d[i-1] + 2*d[i-2]) % delta

print(d[N])