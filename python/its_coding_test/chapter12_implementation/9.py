# 9. 문자열 압축

def solution(s):
    answer = len(s)
    for step in range(1, len(s) // 2 + 1):
        compressed = ''
        prev = s[0:step]
        count = 1
        # 단위만큼 비교하며 이전 문자열과 비교
        for j in range(step, len(s), step):
            if prev == s[j:j+step]:
                count += 1
            else:
                compressed += str(count) + prev if count >= 2 else prev
                count = 1
                prev = s[j:j+step]
        # 남아 있는 문자열에 대한 처리
        compressed += str(count) + prev if count >= 2 else prev

        answer = min(answer, len(compressed))
    return answer


s = input()
print(solution(s))