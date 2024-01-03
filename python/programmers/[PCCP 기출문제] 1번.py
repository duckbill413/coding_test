def solution(bandage, health, attacks):
    max_health = health
    current_time = 0
    for attack_time, attack_damage in attacks:
        flow_time = attack_time - current_time - 1
        health = min(max_health, health + (flow_time // bandage[0]) * bandage[2] +
                     (flow_time * bandage[1]))
        current_time = attack_time
        health -= attack_damage

        if health <= 0:
            return -1
    return health
