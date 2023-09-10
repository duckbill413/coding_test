def solution(players, callings):
    race = {}
    for i in range(len(players)):
        race[players[i]] = i

    for calling in callings:
        order = race[calling]
        before = players[order - 1]

        players[order - 1] = calling
        players[order] = before

        race[calling] = order - 1
        race[before] = order

    return players
