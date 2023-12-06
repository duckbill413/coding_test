def solution(arr1, arr2):
    answer = []
    for k in range(len(arr1)):
        tmp = []
        for j in range(len(arr2[0])):
            sum = 0
            for i in range(len(arr2)):
                sum += arr2[i][j] * arr1[k][i]
            tmp.append(sum)
        answer.append(tmp)

    return answer
