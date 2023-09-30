def solution(n):
    root = bin(n).count("1")
    for i in range(n + 1, 1000065):
        count = bin(i).count("1")
        if count == root:
            return i
