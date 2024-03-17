def find_pair(card):
    global target
    return target - card


def need_coin():
    global target, my_cards

    cost = 3
    index = [0, 0]
    for i in range(len(my_cards) // 2 + 1):
        pair = find_pair(i)
        if my_cards[i] == 0 or my_cards[pair] == 0:
            continue

        if my_cards[i] == 1 and my_cards[pair] == 1:
            index[0] = i
            index[1] = pair
            cost = 0
            break
        elif my_cards[i] == 1 and my_cards[pair] == 2:
            if cost > 1:
                index[0] = i
                index[1] = pair
                cost = 1
        elif my_cards[i] == 2 and my_cards[pair] == 2:
            if cost > 2:
                index[0] = i
                index[1] = pair
                cost = 2

    my_cards[index[0]] = 0
    my_cards[index[1]] = 0
    return cost


def solution(coin, cards):
    global target, my_cards
    target = len(cards) + 1
    my_cards = [0] * (len(cards) + 1)

    index = 0
    for i in range(0, len(cards) // 3):
        my_cards[cards[index]] = 1
        index += 1

    round = 1
    while True:
        if index >= len(cards):
            break
        my_cards[cards[index]] = 2
        index += 1
        my_cards[cards[index]] = 2
        index += 1

        result = need_coin()
        if result == 3 or result > coin:
            break
        else:
            coin -= result
        round += 1
    return round
