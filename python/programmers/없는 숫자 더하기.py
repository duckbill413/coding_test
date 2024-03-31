def solution(numbers):
    dp = [0] * 10

    for number in numbers:
        dp[number] += 1

    answer = 0
    for i in range(10):
        if dp[i] == 0:
            answer += i
    return answer
