import sys; input = sys.stdin.readline
from bisect import bisect_left
N = int(input())
s, l = list(map(int,input().split())), list(map(int,input().split()))
idxs = [l.index(v) for v in s]
res = [idxs[0]]
cnt = [1]
for v in idxs[1:]:
    if res[-1]<v: 
        res.append(v)
        cnt.append(len(res))
    else:
        idx = bisect_left(res,v)
        res[idx] = v
        cnt.append(idx+1)

tmp = len(res)
print(tmp)
ans = []
for i in range(N-1,-1,-1):
    if tmp==cnt[i]:
        ans.append(s[i])
        tmp-=1
print(*sorted(ans))