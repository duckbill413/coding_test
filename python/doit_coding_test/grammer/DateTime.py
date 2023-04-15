from datetime import datetime

now = datetime.now()
print(now)

'''
year: 연도
month: 월
day: 일
hour: 시
minute: 분
second: 초
microsecond: 마이크로초(micro seconds, 백만분의 일초)
'''
print(now.year, now.month, now.second)

# weekday: 요일 반환 (0:월, 1:화, 2:수, 3:목, 4:금, 5:토, 6:일)
print(now.weekday())

# strftime: 문자열 반환
'''
%Y  앞의 빈자리를 0으로 채우는 4자리 연도 숫자
%m  앞의 빈자리를 0으로 채우는 2자리 월 숫자
%d  앞의 빈자리를 0으로 채우는 2자리 일 숫자
%H  앞의 빈자리를 0으로 채우는 24시간 형식 2자리 시간 숫자
%M  앞의 빈자리를 0으로 채우는 2자리 분 숫자
%S  앞의 빈자리를 0으로 채우는 2자리 초 숫자
%A  영어로 된 요일 문자열
%B  영어로 된 월 문자열
'''
print(now.strftime("%Y-%m-%d %H:%M:%S"))

print(datetime.strptime('2023년 4월 15일 12:36', '%Y년 %m월 %d일 %H:%M'))

# date: 날짜 정보만 가지는 date 클래스 객체 반환
print(now.date())
# time: 시간 정보만 가지는 time 클래스 객체 반환
print(now.time())

# 날짜 시간 연산
dt1 = datetime(2023, 2, 19, 14, 12)
dt2 = datetime(2023, 4, 10, 15, 9)
td = dt2 - dt1 # td는 time_delta class
print(td)

print(td.days, td.seconds, td.total_seconds())

from datetime import timedelta

d = timedelta(days=40, seconds=30)
print(now + d)