words = [
    "aya", "ye", "woo", "ma"
]


def solution(babbling):
    answer = 0

    for b in babbling:
        isOk = True
        before = ""
        idx = 0

        while idx < len(b):
            find = False
            for w in words:
                if b[idx:idx + len(w)] == w:
                    if before == w:
                        isOk = False
                    before = w
                    find = True
                    idx += len(w)
                    break
            if not find:
                isOk = False
                break

            if not isOk:
                break
        if isOk:
            answer += 1

    return answer
