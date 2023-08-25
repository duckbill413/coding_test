from collections import Counter

N = int(input())
A = list(map(int, input().split()))
V = int(input())

count = Counter(A)
print(count[V])