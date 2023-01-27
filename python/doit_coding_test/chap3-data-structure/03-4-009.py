# 12891 DNA 비밀번호 - 슬라이딩 윈도우

S, P = map(int, input().split())
words = input()
A, C, G, T = map(int, input().split())

check = {'A': 0, 'C': 0, 'G': 0, 'T': 0}
count = 0
for i in range(len(words)):
    check[words[i]] += 1
    if i >= P:
        check[words[i - P]] -= 1
    if check['A'] >= A and check['C'] >= C and check['G'] >= G and check['T'] >= T and i >= P - 1:
        count += 1

print(count)