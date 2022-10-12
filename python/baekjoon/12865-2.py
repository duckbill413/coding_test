# 12854. 평범한 배낭 / 람다
m,r=lambda:map(int,input().split()),range
n,k=m()
d=[0]*(k+1)
for _ in r(n):
    w,v=m()
    for i in r(k,w-1,-1):
        d[i]=max(d[i],d[i-w]+v)
print(d[k])