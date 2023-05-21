T = int(input())

for t in range(1, T+1):
    P, Q, R, S, W = map(int, input().split())

    A = P * W
    B = Q if W <= R else Q + (W-R) * S
    print('#'+str(t), min(A, B))