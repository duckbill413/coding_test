def dfs(index, depth, skill_tree):
    global answer, Skill, s
    if depth == len(Skill):
        answer += 1
        return
    if index == len(skill_tree):
        answer += 1
        return

    if skill_tree[index] not in s:
        dfs(index + 1, depth, skill_tree)
    else:
        if skill_tree[index] == Skill[depth]:
            dfs(index + 1, depth + 1, skill_tree)
        else:
            return


def solution(skill, skill_trees):
    global answer, s, Skill
    answer = 0
    s = set(skill)
    Skill = skill

    for skill_tree in skill_trees:
        dfs(0, 0, skill_tree)
    return answer


skill = "CBD"
skill_trees = ["BACDE", "CBADF", "AECB", "BDA"]
print(solution(skill, skill_trees))
