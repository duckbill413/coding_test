def solution(alp, cop, problems):
    global alp_goal, cop_goal, dp

    problems.append([0, 0, 1, 0, 1])
    problems.append([0, 0, 0, 1, 1])

    alp_goal, cop_goal = 0, 0
    for problem in problems:
        alp_goal = max(alp_goal, problem[0])
        cop_goal = max(cop_goal, problem[1])

    alp = min(alp, alp_goal)
    cop = min(cop, cop_goal)

    dp = [[int(1e9) for j in range(cop_goal + 1)] for i in range(alp_goal + 1)]
    dp[alp][cop] = 0

    for i in range(alp, alp_goal + 1):
        for j in range(cop, cop_goal + 1):
            for problem in problems:
                if i >= problem[0] and j >= problem[1]:
                    next_alp = min(alp_goal, i + problem[2])
                    next_cop = min(cop_goal, j + problem[3])
                    dp[next_alp][next_cop] = min(dp[next_alp][next_cop], dp[i][j] + problem[4])

    return dp[alp_goal][cop_goal]


alp = 10
cop = 10
problems = [[10, 15, 2, 1, 2], [20, 20, 3, 3, 4]]
print(solution(alp, cop, problems))
