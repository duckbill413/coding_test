def solution(strings, n):
    def sort_key(x):
        return tuple(x[(i + n) % (n + 1)] for i in range(n + 1)), x

    return sorted(strings, key=sort_key)
