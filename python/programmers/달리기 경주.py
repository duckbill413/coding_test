def solution(players, callings):

    for call in callings:
        for i in range(len(players)):
            if players[i] == call:
                players.insert(i-1,players[i])
                players.pop(i+1)
                break
    return players