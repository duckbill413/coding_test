def solution(s):
    stack = []

    for i in s:
        if not stack:
            stack.append(i)
        else:
            if i == '(':
                stack.append(i)
            else:
                if stack[-1] == '(':
                    stack.pop()
                else:
                    return False

    if len(stack) > 0:
        return False

    return True


s = "(())()"
print(solution(s))