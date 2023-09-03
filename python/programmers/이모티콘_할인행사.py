def solution(users, emoticons):
    answer = [0, 0]
    discount = [10, 20, 30, 40]

    discount_list = [0] * len(emoticons)

    def dfs(count):
        nonlocal answer
        if count == len(emoticons):
            result = [0, 0]
            for user in users:
                price = 0
                for i in range(len(emoticons)):
                    if discount_list[i] >= user[0]:
                        price += emoticons[i] * ((100 - discount_list[i]) / 100)
                if price >= user[1]:
                    result[0] += 1
                else:
                    result[1] += price

            if answer[0] < result[0]:
                answer = result
            elif answer[0] == result[0] and answer[1] < result[1]:
                answer = result
            return

        for dd in discount:
            discount_list[count] = dd
            dfs(count + 1)

    dfs(0)

    return answer
