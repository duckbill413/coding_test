def solution(prices):
    time = [0] * len(prices)
    stack = []

    for idx, price in enumerate(prices):
        for i in stack:
            time[i] += 1
        while stack and prices[stack[-1]] > price:
            stack.pop()
        stack.append(idx)

    return time