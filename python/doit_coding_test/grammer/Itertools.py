import collections
import itertools

l = [1, 2, 3]

# combinations(iterable, r) : iterable에서 원소 개수가 r개인 조합 뽑기
print(list(itertools.combinations(l, 2)))

# combinations_with_replacement(iterable, r) : iterable에서 원소 개수가 r인 중복 조합 뽑기
print(list(itertools.combinations_with_replacement(l, 2)))

# permutations(iterable, r=None) : iterable에서 원소의 개수가 r인 순열 뽑기
print(list(itertools.permutations(l)))
print(list(itertools.permutations(l, 2)))

# product(*iterables, repeat=1): 여러 iterables의 데카르트 곱 리턴
l1 = ['A', 'B']
l2 = ['1', '2']

print(list(itertools.product(l1, l2, repeat=2)))