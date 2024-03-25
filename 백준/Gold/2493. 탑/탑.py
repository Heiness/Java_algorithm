import sys; input = sys.stdin.readline
N = int(input())
h = list(map(int,input().split()))
stack = [N-1]
ans = [0] * N

for i in range(N-2,-1,-1):
    while stack and h[stack[-1]] < h[i]:
        ans[stack.pop()] = i+1;
    stack.append(i)
    
print(*ans)