from queue import PriorityQueue
import sys
print = sys.stdout.write
input = sys.stdin.readline

N = int(input())
myQueue = PriorityQueue()

for i in range(N):
    request = int(input())
    if request == 0:
        if myQueue.empty():
            print('0\n')
        else:
            temp = myQueue.get()
            print(str((temp[1])) + '\n')
    else:
        myQueue.put((abs(request), request))


'''
myQueue.put((abs(request), request)) 코드의 정렬 순서가 1: 절댓값, 2: 음수 인 것은 파이썬에서는 우선순위 큐에 데이터를 추가할 때 순서가 정렬 우선순위의 기준이 되기 때문입니다.
abs(request)가 절댓값을 나타내므로 먼저 절댓값을 기준으로 정렬합니다. 
그 다음으로 request를 기준으로 정렬하므로 절댓값이 같다면 양수인지 음수인지를 비교하여 음수 우선으로 정렬합니다.
'''