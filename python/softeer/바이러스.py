K, P, N = map(int, input().split())
answer = K
MOD = 1000000007

for i in range(N):
    answer = (answer * P) % MOD
print(answer)