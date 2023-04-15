import collections

# 카운트
'''
보유한 주식이 다음과 같을 때, 종목별로 합산해 나타내고 싶다고 하자.
'''
portfolio = [
    ('GOOG', 100, 490.1),
    ('IBM', 50, 91.1),
    ('CAT', 150, 83.44),
    ('IBM', 100, 45.23),
    ('GOOG', 75, 572.45),
    ('AA', 50, 23.15)
]
total_shares = collections.Counter()
for name, shares, prices in portfolio:
    total_shares[name] += shares

print(total_shares['IBM'])