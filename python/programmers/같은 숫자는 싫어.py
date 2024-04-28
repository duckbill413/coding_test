def solution(arr):
    answer = [arr[0]]
    for a in arr[1:]:
        if answer[-1] != a:
            answer.append(a)
    return answer
