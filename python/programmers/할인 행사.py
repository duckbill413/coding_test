import collections

def solution(want, number, discount):
    products = collections.defaultdict(int)

    answer = 0
    for i in range(len(discount)):
        products[discount[i]] += 1
        if i >= 9: # 10일째 날 부터 검사 시작
            isOk = True
            for w, n in zip(want, number):
                if products[w] < n:
                    isOk = False
                    break
            if isOk:
                answer += 1
            products[discount[i-9]] -= 1

    return answer