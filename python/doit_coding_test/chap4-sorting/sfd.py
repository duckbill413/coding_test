A = list(map(int, input().split()))
count = 0
for i in range(len(A)-1):
    for j in range(len(A) - i -1):
        if A[j] > A[j+1]:
            A[j], A[j+1] = A[j+1], A[j]
            count += 1

print(A, count)