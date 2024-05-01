import collections

def solution(nums):
    pocketmon = collections.defaultdict(int)
    for num in nums:
        pocketmon[num] += 1

    N = len(nums) // 2

    return len(pocketmon) if len(pocketmon) <= N else N