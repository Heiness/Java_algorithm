import sys; input = sys.stdin.readline
from bisect import bisect_left
N = int(input()); nums = list(map(int,input().split()))
res = [nums[0]]

for v in nums[1:]:
    if res[-1] < v: res.append(v)
    else: res[bisect_left(res,v)] = v

print(N-len(res))