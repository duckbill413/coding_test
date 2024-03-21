def solution(sizes):
    big=[]
    small=[]
    for size in sizes:
        big.append(max(size))
        small.append(min(size))

    return max(big) * max(small)