def solution(s):
    nums = sorted(list(map(int, s.split())))
    return f'{nums[0]} {nums[-1]}'