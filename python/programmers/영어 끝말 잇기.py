def solution(n, words):
    order = 1
    round = 1

    answer = [0, 0]

    d = set()
    last = words[0][0]
    for word in words:
        if word not in d and word[0] == last:
            d.add(word)
            last = word[-1]
        else:
            answer = [order, round]
            break
        if order % n == 0:
            order = 1
            round += 1
        else:
            order += 1

    return answer


n = 2
words = ["hello", "one", "even", "never", "now", "world", "draw"]
print(solution(n, words))