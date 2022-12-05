def solution(id_list, k):
    coupons = {}
    answer = 0

    for id in id_list:
        day = id.split()
        day_list = []
        for i in day:
            if i not in day_list:
                if i in coupons:
                    if coupons[i] < k:
                        coupons[i] += 1
                        answer += 1
                else:
                    coupons[i] = 1
                    answer += 1
                day_list.append(i)
    return answer


id_list = ["A B C D", "A D", "A B D", "B D"]
id_list = ["JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"]
k = 3
print(solution(id_list, k))
