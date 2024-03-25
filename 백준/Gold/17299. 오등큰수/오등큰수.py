import sys; input = sys.stdin.readline
N = int(input())
ans = [-1] * N
nums = list(map(int,input().split()))
counter = [0] * 1000001
for i in nums: counter[i]+=1
stack = [0]

for i in range(1,N):
    while stack and counter[nums[stack[-1]]] < counter[nums[i]]:
        ans[stack.pop()] = nums[i]
    stack.append(i)
print(" ".join(map(str,ans)))