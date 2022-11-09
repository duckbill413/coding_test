# 23. 국영수

def solution(students):
    students.sort(key=lambda s:(-int(s[1]), int(s[2]), -int(s[3]), s[0]))
    for student in students:
        print(student[0])

n = int(input())
students = []
for i in range(n):
    tmp = list(map(str, input().split()))
    students.append(tmp)

solution(students)
'''
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90
'''