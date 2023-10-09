g = {
    '[': ']',
    ']': '[',
    '{': '}',
    '}': '{',
    '(': ')',
    ')': '('
}


def solution(s):
    answer = 0
    for i in range(len(s)):
        s = s[1:] + s[0]

        st = []
        flag = True
        for w in s:
            if w == ']' or w == ')' or w == '}':
                if len(st) == 0 or st[-1] != g[w]:
                    flag = False
                    break
                else:
                    st.pop()
            else:
                st.append(w)

        if len(st) == 0 and flag:
            answer += 1
    return answer
