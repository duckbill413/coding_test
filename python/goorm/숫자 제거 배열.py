N, K = map(int, input().split())
A = list(map(int, input().split()))

# -----------------CASE 1--------------------
answer = N
k = list(str(K))
for a in A:
    tmp = list(str(a))

    result = False
    for i in range(len(tmp) - len(k) + 1):
        check = True
        for j in range(len(k)):
            if tmp[i + j] != k[j]:
                check = False
                break
        if check:
            result = True
            # print(">>", a)
            break

    if result:
        answer -= 1

print(answer)

# -----------------CASE 2--------------------
answer = N
for a in A:
    if str(K) in str(a):
        answer -= 1

print(answer)
