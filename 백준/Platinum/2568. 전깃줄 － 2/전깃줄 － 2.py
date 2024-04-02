import sys; input = sys.stdin.readline
from bisect import bisect_left
N = int(input())
cs = [ list(map(int,input().split())) for _ in range(N) ]
cs = sorted(cs, key=lambda x: x[0])
cnt = [1]
res = [cs[0][1]]
ml = 1
for i,v in cs[1:]:
    if res[-1] < v:
        res.append(v)
        ml+=1
        cnt.append(ml)
    else:
        idx = bisect_left(res,v)
        res[idx] = v
        cnt.append(idx+1)

print(N-ml)
ans = []
for i in range(N-1,-1,-1):
    if ml==cnt[i]: 
        ml-=1
        continue
    ans.append(cs[i][0])
while ans:
    print(ans.pop())