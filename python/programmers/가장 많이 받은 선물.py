def solution(friends, gifts):
    friends_index = {}
    friends_gift = [[0] * len(friends) for _ in range(len(friends))]
    gift_degree = [0] * len(friends)

    # 친구 index 초기화
    for index, friend in enumerate(friends):
        friends_index[friend] = index

    for gift in gifts:
        sender, receiver = gift.split()
        sender_index = friends_index[sender]
        receiver_index = friends_index[receiver]

        # 선물 인접리스트 생성
        friends_gift[sender_index][receiver_index] += 1
        gift_degree[sender_index] += 1
        gift_degree[receiver_index] -= 1

    next_gift = [0] * len(friends)

    for i in range(len(friends)):
        for j in range(i + 1, len(friends)):
            if i == j: continue

            # 선물을 주고 받은 개수가 다른 경우
            if friends_gift[i][j] != friends_gift[j][i]:
                if friends_gift[i][j] > friends_gift[j][i]:
                    next_gift[i] += 1
                else:
                    next_gift[j] += 1
            # 선물을 주고 받은 개수가 같은 경우
            else:
                if gift_degree[i] > gift_degree[j]:
                    next_gift[i] += 1
                elif gift_degree[i] < gift_degree[j]:
                    next_gift[j] += 1
    return max(next_gift)
